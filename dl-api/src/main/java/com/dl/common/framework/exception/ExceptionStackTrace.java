package com.dl.common.framework.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ExceptionStackTrace {

	/**
	 * 解析异常栈跟踪信息
	 * @param e
	 * @return
	 */
	public static String pretty(Exception e){
		StringBuilder builder = new StringBuilder();
		StackTraceElement[] stEls = e.getStackTrace();
		builder.append(e.getMessage());
		int lenStack = stEls.length < 20 ? stEls.length : 20;
		for (int i = 0; i < lenStack; i++) {
			builder.append(stEls[i].getClassName()).append(".").append(stEls[i].getMethodName()).append("(").append(stEls[i].getFileName()).append(":")
					.append(stEls[i].getLineNumber()).append(")<br>");
		}
		return builder.toString();
	}
	
	/**
	 * 解析异常栈跟踪信息
	 * @param e
	 * @return
	 */
	public static List<String> stackMsgArray(Exception e){
		List<String> stackMsgArr = new ArrayList<String>();
		StackTraceElement[] stEls = e.getStackTrace();
		int lenStack = stEls.length < 20 ? stEls.length : 20;
		for (int i = 0; i < lenStack; i++) {
			stackMsgArr.add(StringUtils.join(stEls[i].getClassName(), ".", stEls[i].getMethodName(), "(", stEls[i].getFileName(), ":",
					"" + stEls[i].getLineNumber(), ")<br>"));
		}

		return stackMsgArr;
	}
}
