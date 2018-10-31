package com.dl.common.framework.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.dl.common.config.ParamProps;
import com.dl.common.framework.logger.LoggerUtil;
import com.dl.common.utils.web.WebUtils;

/**
 * 参数处理
 * 	1、解析头部参数token、userId
 * 	2、参数非空校验
 * @author levi.liu
 *
 */
public class ParamCheckInterceptor extends BaseInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		//获取当前请求的URL，校验是否需要非空校验
		String url = request.getServletPath();
		String params = ParamProps.getValue(url);
		if(StringUtils.isNotEmpty(params)){
			LoggerUtil.info(String.format("[ParamCheckInterceptor][preHandle][checkParam][%s]:%s", url,params));
			String[] checkList = params.split(",");
			String requestBodyStr = WebUtils.readBody(request);
			String token = request.getHeader("token");
			String userId = request.getHeader("userId");
			for(int i = 0 ; i < checkList.length ; i++){
				String param = checkList[i];
				if(param.equals("token")){
					if(StringUtils.isEmpty(token)){
						return false;
					}
				} else if(param.equals("userId")){
					if(StringUtils.isEmpty(userId)){
						return false;
					}
				} else {
					String value = (String) JSONObject.parseObject(requestBodyStr).get(param);
					if(StringUtils.isEmpty(value)){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("ParamCheckInterceptor----postHandle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("ParamCheckInterceptor----afterCompletion");
	}
}
