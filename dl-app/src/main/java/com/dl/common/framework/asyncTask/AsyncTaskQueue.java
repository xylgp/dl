package com.dl.common.framework.asyncTask;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import com.dl.common.framework.logger.LoggerUtil;

/**
 * 异步线程队列
 * @author levi.liu
 *
 */
public class AsyncTaskQueue {
	
	//唯一实例
	private static AsyncTaskQueue mine = new AsyncTaskQueue();
	//同步锁
	private static Object lock = new Object();
	//异步队列
	private static BlockingQueue<AsyncTask> taskQueue = new ArrayBlockingQueue<>(50);
	//私有化构造函数
	private AsyncTaskQueue() {}
	
	public AsyncTaskQueue getInstance() {
		synchronized (lock) {
			if(mine == null){
				mine = new AsyncTaskQueue();
			}
			return mine;
		}
	}
	
	/**
	 * 单个添加异步任务
	 * @param task
	 */
	public static void offer(AsyncTask task){
		taskQueue.offer(task);
	}
	
	/**
	 * 批量添加异步任务
	 * @param taskList
	 */
	public static void offer(List<AsyncTask> taskList){
		for(AsyncTask task : taskList){
			taskQueue.offer(task);
		}
	}
	
	/**
	 * 从队列中获取任务 
	 * @return
	 */
	public static AsyncTask take(){
		try {
			return taskQueue.take();
		} catch (Exception e) {
			LoggerUtil.error("taskQueue take error",e);
			return null;
		}
	}
	
	/**
	 * 取走队列的收条记录，如果不能立即获取，等待指定秒数，如果还去不到返回null
	 * @param timeout
	 * @return
	 */
	public static AsyncTask take(long timeout){
		try {
			return taskQueue.poll(timeout, TimeUnit.SECONDS);
		} catch (Exception e) {
			LoggerUtil.error("taskQueue take error",e);
			return null;
		}
	}
}
