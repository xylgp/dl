package com.dl.common.framework.threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.dl.common.framework.logger.LoggerUtil;

public class ThreadPoolManager {

	private ExecutorService pool;
	
	private int poolMultiple = 10;
	
	/**
	 * 单线程执行任务
	 * @param task
	 */
	public void exectue(Runnable task){
		if(pool == null){
			pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * poolMultiple);
		}
		pool.execute(task);
	}
	
	/**
	 * 多线程执行任务
	 * @param task
	 * @param count
	 */
	public void execute(Runnable task , int count){
		if(pool == null){
			pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * poolMultiple);
		}
		for (int i = 0; i < count; i++) {
			pool.execute(task);
		}
	}
	
	/**
	 * 立即关闭所有任务线程
	 * @param taskList
	 */
	public void stop(List<BaseThreadTask> taskList) {
		for (BaseThreadTask task : taskList) {
			task.setIsShutdown(true);
		}
		if (pool != null) {
			pool.shutdown();
			try {
				while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
					// do nothing
					LoggerUtil.info("等待子线程关闭。。。");
				}
			} catch (InterruptedException e) {
				LoggerUtil.error(e.getMessage(), e);
			}
			pool.shutdownNow();
		}

		LoggerUtil.info("自定义线程任务已经关闭");
	}

	public ExecutorService getPool() {
		return pool;
	}

	public void setPool(ExecutorService pool) {
		this.pool = pool;
	}

	public int getPoolMultiple() {
		return poolMultiple;
	}

	public void setPoolMultiple(int poolMultiple) {
		this.poolMultiple = poolMultiple;
	}
	
}
