package com.dl.common.framework.redis.vo.story;

import com.dl.common.framework.redis.vo.QueryBaseVo;

public class QueryStoryBaseVo extends QueryBaseVo{

	private static final long serialVersionUID = 1L;
	
	//故事板块
	private String channelCode;
	//每页最大显示数
	private Integer pageSize;
	//每页最小显示数
	private Integer pageMinSize;
	//上拉或下滑
	private Integer upOrDown;
	
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageMinSize() {
		return pageMinSize;
	}
	public void setPageMinSize(Integer pageMinSize) {
		this.pageMinSize = pageMinSize;
	}
	public Integer getUpOrDown() {
		return upOrDown;
	}
	public void setUpOrDown(Integer upOrDown) {
		this.upOrDown = upOrDown;
	}
}
