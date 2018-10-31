package com.dl.common.framework.exception;

import com.dl.common.model.base.ResponseCodeEnum;

public class DlException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;
	private Throwable target;
	
	public DlException(ResponseCodeEnum codeEnum){
		this.errorCode = codeEnum.code;
		this.errorMsg = codeEnum.desc;
	}
	
	public DlException(String errorCode){
		this.errorCode = errorCode;
		this.errorMsg = ResponseCodeEnum.getMsg(errorCode);
	}
	
	public DlException(String errorCode,String errorMsg){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public DlException(String errorCode,String errorMsg,Throwable target){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.target = target;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Throwable getTarget() {
		return target;
	}

	public void setTarget(Throwable target) {
		this.target = target;
	}

}
