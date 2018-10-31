package com.dl.common.model.app.req;

import java.io.Serializable;
import java.util.List;
import com.dl.common.model.entity.user.UserChannel;

public class ChannelRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	//用户id
	private String userId;
	//板块列表
	private List<UserChannel> channelList;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<UserChannel> getChannelList() {
		return channelList;
	}
	public void setChannelList(List<UserChannel> channelList) {
		this.channelList = channelList;
	}
}
