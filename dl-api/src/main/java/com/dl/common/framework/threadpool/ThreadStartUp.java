package com.dl.common.framework.threadpool;

import java.util.List;
import com.dl.common.framework.logger.LoggerUtil;

@SuppressWarnings("unused")
public class ThreadStartUp {
	
	private ThreadPoolManager threadPoolManager;

	private List<BaseThreadTask> taskList;
	
	private void start() {
		LoggerUtil.info("开启自定义线程任务：");
		for (BaseThreadTask task : taskList) {
			threadPoolManager.execute(task, task.getThreadCount());
		}
	}
	
	private void shutdown() {
		LoggerUtil.info("关闭自定义线程任务。。。");
		threadPoolManager.stop(taskList);
	}

	public ThreadPoolManager getThreadPoolManager() {
		return threadPoolManager;
	}

	public void setThreadPoolManager(ThreadPoolManager threadPoolManager) {
		this.threadPoolManager = threadPoolManager;
	}

	public List<BaseThreadTask> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<BaseThreadTask> taskList) {
		this.taskList = taskList;
	}
	
}
