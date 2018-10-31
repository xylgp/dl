package com.dl.common.handler.story.convert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.CheckRecord;
import com.dl.common.model.entity.story.Story;
import com.dl.common.model.entity.story.StoryChannel;
import com.dl.common.model.entity.story.StoryOutline;

public class StoryConvert {

	/**
	 * 转换Story对象
	 * @param request
	 * @return
	 */
	public static Story convertStory(StoryRequest request){
		Story story = new Story();
		story.setUserId(request.getUserId());
		story.setRootId(request.getRootId());
		story.setTitle(request.getTitle());
		story.setContent1(request.getContent1());
		story.setColor1(request.getColor1());
		story.setContent2(request.getContent2());
		story.setColor2(request.getColor2());
		story.setContent3(request.getContent3());
		story.setColor3(request.getColor3());
		story.setIsEndingShow(StringUtils.isEmpty(request.getIsEndingShow())?"1":request.getIsEndingShow());
		return story;
	}
	
	/**
	 * 转换StoryChannel
	 * @param storyId
	 * @param request
	 * @return
	 */
	public static List<StoryChannel> convertStoryChannel(String storyId,StoryRequest request){
		List<StoryChannel> list = new ArrayList<>();
		for(String channel : request.getChannelList()){
			StoryChannel storyChannel = new StoryChannel();
			storyChannel.setStoryId(storyId);
			storyChannel.setChannelCode(channel);
			list.add(storyChannel);
		}
		return list;
	}
	
	/**
	 * 转换成StoryOutline
	 * @param storyId
	 * @param request
	 * @return
	 */
	public static StoryOutline convertStoryOutline(String storyId,StoryRequest request){
		StoryOutline storyOutline = new StoryOutline();
		storyOutline.setId(storyId);
		storyOutline.setRootId(request.getRootId());
		storyOutline.setParentId(request.getParentId());
		storyOutline.setLevelNum(request.getLevelNum());
		return storyOutline;
	}
	
	public static CheckRecord convertCheckRecord(StoryRequest storyReq){
		CheckRecord checkRecord = new CheckRecord();
		checkRecord.setCheckBy(storyReq.getUserId());
		checkRecord.setStoryId(storyReq.getId());
		checkRecord.setRemark(storyReq.getRemark());
		checkRecord.setStatus(storyReq.getStatus());
		checkRecord.setCheckDate(new Date());
		return checkRecord;
	}
	
	public static StoryResponse convertStoryResponse(Story story,StoryResponse response){
		response.setTitle(story.getTitle());
		response.setBackground(story.getBackground());
		response.setColor1(story.getColor1());
		response.setContent1(story.getContent2());
		response.setColor2(story.getColor2());
		response.setContent2(story.getContent2());
		response.setColor3(story.getColor3());
		response.setContent3(story.getContent3());
		response.setRootId(story.getRootId());
		response.setIsEndingShow(story.getIsEndingShow());
		return response;
	}
}
