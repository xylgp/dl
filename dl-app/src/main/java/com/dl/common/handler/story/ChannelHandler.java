package com.dl.common.handler.story;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dl.common.framework.redis.template.RedisStoryTemplate;
import com.dl.common.model.app.req.ChannelResponse;
import com.dl.common.model.entity.story.Channel;
import com.dl.common.model.entity.user.UserChannel;
import com.dl.common.service.story.ChannelService;
import com.dl.common.service.user.UserChannelService;

@Component
public class ChannelHandler {

	@Autowired
	private ChannelService channelService;
	@Autowired
	private UserChannelService userChannelService;
	@Autowired
	private RedisStoryTemplate storyTemplate;
	
	public List<Channel> getDefaultChannelList(){
		//获取redis中的数据
		List<Channel> channelList = storyTemplate.getDefaultChannel(null);
		//如果不存在,查询并存储redis
		if(null == channelList){
			channelList = channelService.getDefaultChannelList();
			storyTemplate.storeDefaultChannel(null, channelList);
		}
		return channelList;
	}
	
	/**
	 * 获取全部板块
	 * @return
	 */
	public List<Channel> getFullChannelList(){
		//获取redis中的数据
		List<Channel> channelList = storyTemplate.getFullChannel(null);
		//如果不存在,查询并存储redis
		if(null == channelList){
			channelList = channelService.getDefaultChannelList();
			storyTemplate.storeFullChannel(null, channelList);
		}
		return channelList;
	}
	
	/**
	 * 新僧用户自定义板块
	 * @param userId
	 * @param channelList
	 */
	public void insertUserChannelList(String userId,List<UserChannel> channelList){
		//删除用户的此前存在的记录
		userChannelService.batchDeleteByUserId(userId);
		//保存最新的记录
		for(UserChannel userChannel : channelList) {
			userChannel.setUserId(userId);
			userChannel.setStatus("1");
			userChannel.setCreateTime(new Date());
		}
		userChannelService.insert(channelList);
	}
	
	/**
	 * 获取用户板块，如果没有自定义，返回默认板块
	 * @param userId
	 * @return
	 */
	public List<ChannelResponse> getUserChannelList(String userId){
		List<ChannelResponse> userList = userChannelService.getUserChannelList(userId);
		if(null == userList || userList.size() == 0){
			List<Channel> channelList =  channelService.getDefaultChannelList();
			return parseChannelResponse(channelList);
		}
		return userList;
	}
	
	public void test(String userId){
		channelService.test(userId);
	}
	
	private List<ChannelResponse> parseChannelResponse(List<Channel> channelList){
		List<ChannelResponse> responseList = new ArrayList<>();
		for(Channel channel : channelList){
			ChannelResponse response = new ChannelResponse();
			response.setChannelCode(channel.getChannelCode());
			response.setChannelName(channel.getChannelName());
			response.setSort(channel.getSort());
			responseList.add(response);
		}
		return responseList;
	}
}
