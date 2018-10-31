package com.dl.common.handler.story;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.dl.common.framework.redis.RedisService;
import com.dl.common.framework.redis.redisKey.RedisStoryKey;
import com.dl.common.framework.redis.utils.RedisKeyUtil;
import com.dl.common.framework.redis.utils.RedisMapUtil;
import com.dl.common.model.app.req.StoryListRequest;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.Channel;
import com.dl.common.service.story.ChannelService;
import com.dl.common.service.story.StoryChannelService;
import com.dl.common.utils.date.DateFormat;
import com.dl.common.utils.date.DateUtils;
import redis.clients.jedis.Jedis;

@Component
public class StoryChannelHandler {
	
	@Autowired
	private ChannelService channelService;
	@Autowired
	private StoryChannelService storyChannelService;
	@Autowired
	private RedisService redisService;
	
	public List<StoryResponse> selectStoryListByPage(StoryListRequest storyReq){
		if(storyReq.getPageSize() == 0) storyReq.setPageSize(10);
		storyReq.setIndex(storyReq.getNowPage() * storyReq.getPageSize());
 		return storyChannelService.selectStoryListByPage(storyReq);
	}
	
	public List<StoryResponse> batchStoreStoryRedis(){
		//查询所有启用的板块
		List<Channel> channelList = channelService.getFullChannelList();
		for(Channel channel : channelList){
			storeStoryRedis(channel.getChannelCode(), channel.getCacheLimit());
		}
		return null;
	}
	
	/**
	 * 缓存指定板块的故事，每个板块配置自己的缓存上限
	 * @param channelCode
	 * @param cacheLimit
	 * @return
	 */
	public String storeStoryRedis(String channelCode,int cacheLimit){
		if(0 == cacheLimit){
			//查询板块的缓存上限
			Channel channel = channelService.getByChannelCode(channelCode);
			cacheLimit = channel.getCacheLimit();
		}
		//查询最新的limit条故事（审批通过+能显示）
		List<StoryResponse> storyList = storyChannelService.selectStoryListByCodeAndLimit(channelCode, cacheLimit);
		//获取查询到的最新和最旧的故事的发布时间，并创建中间时间的List
		Date beginDate = storyList.get(0).getCreateTime();
		Date endDate = storyList.get(storyList.size()-1).getCreateTime();
		List<String> hourList = DateUtils.betweenHourList(beginDate, endDate);
		Jedis jedis = null;
		try {
			//循环hourList，在redis中创建Map
			jedis = redisService.getJedis();
			for(String hourKey : hourList){
				String key = RedisKeyUtil.createRedisKeyStory(RedisStoryKey.STORY_LIST,channelCode,hourKey);
				Map<String, String> init = new HashMap<String, String>();
				init.put("init", "init");
				new RedisMapUtil().insertHash(jedis, key, init);
			}
			//循环查询的数据，放到对应的redis map中
			for(StoryResponse story : storyList){
				String hourKey = DateUtils.formatDate(story.getCreateTime(), DateFormat.FORMAT_yyyyMMddHH);
				String key = RedisKeyUtil.createRedisKeyStory(RedisStoryKey.STORY_LIST,channelCode,hourKey);
				new RedisMapUtil().hSet(jedis, key, story.getId(),JSONObject.toJSONString(story) );
			}
		} finally {
			//释放连接
		}
		
		
		return null;
	}
}
