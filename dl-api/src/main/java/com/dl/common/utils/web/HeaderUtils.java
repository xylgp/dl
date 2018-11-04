package com.dl.common.utils.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * web请求头部参数工具类
 * @author liuguangping
 *
 */
public class HeaderUtils {
	
	/**
	 * 批量获取指定的头部参数
	 * @param request
	 * @param headers
	 * @return
	 */
	public static Map<String, String> getHadeMap(HttpServletRequest request,String... headers){
		Map<String, String> headerMap = new HashMap<>();
		for(String header : headers){
			headerMap.put(header, request.getHeader(header));
		}
		return headerMap;
	}
}
