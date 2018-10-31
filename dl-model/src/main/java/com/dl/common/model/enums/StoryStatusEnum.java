package com.dl.common.model.enums;

public enum StoryStatusEnum {
	
	WAIT_CHECK("0","待审核"),
	DO_CHECK("1","审核中"),
	SUCCESS_CHECK("2","审核通过"),
	FLASE_CHECK("3","审核不通过"),
	
	;
	
	public String status;
	public String desc;
	
	StoryStatusEnum(String status,String desc) {
		this.status = status;
		this.desc = desc;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
