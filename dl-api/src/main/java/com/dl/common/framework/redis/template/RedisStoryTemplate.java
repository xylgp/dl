package com.dl.common.framework.redis.template;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.dl.common.framework.redis.redisKey.RedisStoryKey;
import com.dl.common.framework.redis.utils.RedisKeyUtil;
import com.dl.common.model.entity.story.Channel;
import redis.clients.jedis.Jedis;

@Component
public class RedisStoryTemplate {
	
	/**
	 * 存储默认板块List
	 * @param channelList
	 */
	public void storeDefaultChannel(Jedis jedis,List<Channel> channelList){
		jedis.set(RedisKeyUtil.createRedisKeyStory(RedisStoryKey.CHANNEL,RedisStoryKey.DEFAULT_CHANNEL_LIST), JSONObject.toJSONString(channelList));
	}
	
	/**
	 * 获取默认板块列表
	 * @param jedis
	 * @return
	 */
	public List<Channel> getDefaultChannel(Jedis jedis){
		String channelListStr = jedis.get(RedisKeyUtil.createRedisKeyStory(RedisStoryKey.CHANNEL,RedisStoryKey.DEFAULT_CHANNEL_LIST));
		if(StringUtils.isEmpty(channelListStr)){
			return null;
		}
		List<Channel> channelList = JSONObject.parseArray(channelListStr, Channel.class);
		return channelList;
	}
	
	/**
	 * 存储全部板块List
	 * @param channelList
	 */
	public void storeFullChannel(Jedis jedis,List<Channel> channelList){
		jedis.set(RedisKeyUtil.createRedisKeyStory(RedisStoryKey.CHANNEL,RedisStoryKey.FULL_CHANNEL_LIST), JSONObject.toJSONString(channelList));
	}
	
	/**
	 * 获取全部板块列表
	 * @param jedis
	 * @return
	 */
	public List<Channel> getFullChannel(Jedis jedis){
		String channelListStr = jedis.get(RedisKeyUtil.createRedisKeyStory(RedisStoryKey.CHANNEL,RedisStoryKey.FULL_CHANNEL_LIST));
		if(StringUtils.isEmpty(channelListStr)){
			return null;
		}
		List<Channel> channelList = JSONObject.parseArray(channelListStr, Channel.class);
		return channelList;
	}
}
