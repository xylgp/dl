package com.dl.common.framework.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class ShiroSessionListener implements SessionListener{

	@Override
	public void onExpiration(Session paramSession) {
		System.out.println(paramSession.getId()+"onExpiration");
	}

	@Override
	public void onStart(Session paramSession) {
		System.out.println(paramSession.getId()+"onStart");
	}

	@Override
	public void onStop(Session paramSession) {
		System.out.println(paramSession.getId()+"onStop");
		
	}

}
