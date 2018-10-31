package com.dl.common.model.base;

public class BaseReqEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	private int nowPage;
	private int pageSize;
	private int index;
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
