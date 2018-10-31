package com.dl.common.framework.threadpool;

public abstract class BaseThreadTask implements Runnable{
	
	//关闭线程标识
	protected Boolean isShutdown = false; 
	
	//执行任务的线程数量 默认为1
	protected int threadCount = 1; 

	public Boolean getIsShutdown() {
		return isShutdown;
	}

	public void setIsShutdown(Boolean isShutdown) {
		this.isShutdown = isShutdown;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}
	
}
