package com.dl.common.framework.shiro;

import java.util.HashSet;
import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.dl.common.handler.user.LoginHandler;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.model.enums.LoginTypeEnum;

public class CustomRelam extends AuthorizingRealm{
	
	@Autowired
	private LoginHandler loginHandler;
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		UserRequest userRequest = (UserRequest) principals.fromRealm(getName()).iterator().next();
		//获取用户权限
		userRequest = loginHandler.buildRoleAndAuth(userRequest, userRequest.getUser());
		if(null != userRequest.getAuthList() && null != userRequest.getRoleList()){
			
			// 基于Permission的权限信息
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			Set<String> permissions = new HashSet<>();
			Set<String> roles = new HashSet<String>();
			for (String auth : userRequest.getAuthList()) {
				permissions.add(auth);
			}
			for (String role : userRequest.getRoleList()) {
				roles.add(role);
			}
			info.setStringPermissions(permissions);
			info.setRoles(roles);
			//响应成功
			return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		//获取请求参数
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authToken;
		UserRequest userRequest = JSONObject.parseObject(usernamePasswordToken.getUsername(), UserRequest.class);
		//获取登录名
		String loginName = LoginTypeEnum.buildLoginName(userRequest.getLoginType(), userRequest.getUserName());
		userRequest.setFullUserName(loginName);
		//校验是否允许的登录方式
		loginHandler.checkLoginType(userRequest);
		userRequest = loginHandler.buildPassword(userRequest);
		return new SimpleAuthenticationInfo(userRequest, userRequest.getBuildPassWd(), getName());
	}
}
