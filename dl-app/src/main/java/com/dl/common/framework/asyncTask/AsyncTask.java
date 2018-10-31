package com.dl.common.framework.asyncTask;

public class AsyncTask {

	private AsyncTaskEnum taskEnum;
	private Object param;
	
	public AsyncTask(AsyncTaskEnum taskEnum , Object param) {
		this.taskEnum = taskEnum;
		this.param = param;
	}
	
	public AsyncTaskEnum getTaskEnum() {
		return taskEnum;
	}

	public void setTaskEnum(AsyncTaskEnum taskEnum) {
		this.taskEnum = taskEnum;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public enum AsyncTaskEnum {
		ASYNC_PUT_ATTENTION("被关注人发布故事"),
		;
		private String desc;

		private AsyncTaskEnum(String desc) {
			this.desc = desc;
		}
		
		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
		
	}
}
