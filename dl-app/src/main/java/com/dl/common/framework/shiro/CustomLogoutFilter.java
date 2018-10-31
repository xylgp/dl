package com.dl.common.framework.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.LogoutFilter;

public class CustomLogoutFilter extends LogoutFilter{
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		return super.preHandle(request, response);
	}

	@Override
	protected void issueRedirect(ServletRequest request, ServletResponse response, String redirectUrl) throws Exception {
		super.issueRedirect(request, response, redirectUrl);
	}
}
