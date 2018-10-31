package com.dl.common.framework.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BaseInterceptor extends HandlerInterceptorAdapter {

	private BaseInterceptor[] nextInterceptor;

	public void setNextInterceptor(BaseInterceptor... nextInterceptor) {
		this.nextInterceptor = nextInterceptor;
	}

	/**
	 * 调用Controller之前被调用，
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (nextInterceptor == null) {
			return true;
		}
		for (int i = 0; i < nextInterceptor.length; i++) {
			if (!nextInterceptor[i].preHandle(request, response, handler)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 调用Controller之后，渲染页面之前
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (nextInterceptor != null) {
			for (int i = 0; i < nextInterceptor.length; i++) {
				nextInterceptor[i].postHandle(request, response, handler, modelAndView);
			}
		}
	}

	/**
	 * 调用完Controller之后，渲染页面之后
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (nextInterceptor != null) {
			for (int i = 0; i < nextInterceptor.length; i++) {
				nextInterceptor[i].afterCompletion(request, response, handler, ex);
			}
		}
	}
}
