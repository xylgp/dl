package com.dl.common.model.app.req;

import java.io.Serializable;

public class ChannelResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
    //字段名称：编码
	private String channelCode;

    //字段名称：板块名
	private String channelName;

    //字段名称：排序
	private int sort;

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
}
