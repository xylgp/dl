package com.dl.common.model.app.req;

import com.dl.common.model.base.BaseReqEntity;

public class StoryListRequest extends BaseReqEntity{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 板块编码
	 */
	private String channelCode;
	
	/**
	 * 故事ID
	 */
	private String storyId;
	
	/**
	 * 类型：1、刷新，2、更多
	 */
	private String type;

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getStoryId() {
		return storyId;
	}

	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
 }
