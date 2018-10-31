package com.dl.common.handler.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.dl.common.framework.exception.DlException;
import com.dl.common.framework.redis.template.RedisUserTemplate;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.model.app.req.UserResponse;
import com.dl.common.model.base.ResponseCodeEnum;
import com.dl.common.model.constant.Constant;
import com.dl.common.model.entity.user.User;
import com.dl.common.model.enums.LoginTypeEnum;
import com.dl.common.service.user.AuthService;
import com.dl.common.service.user.RoleService;
import com.dl.common.service.user.UserService;
import com.dl.common.utils.common.UIDUtils;
import com.dl.common.utils.encryption.md5.MD5Util;

@Component
public class LoginHandler {
	
	@Autowired
	private RegisterHandler registerHandler;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private AuthService authService;
	@Autowired
	RedisUserTemplate userTemplate;
	
	public UserResponse login(UserRequest userRequest){
		//获取登录名
		String loginName = LoginTypeEnum.buildLoginName(userRequest.getLoginType(), userRequest.getUserName());
		userRequest.setFullUserName(loginName);
		//校验是否允许的登录方式
		checkLoginType(userRequest);
		//校验密码
		userRequest = buildPassword(userRequest);
		if(!userRequest.getBuildPassWd().equals(userRequest.getPasswd())){
			throw new DlException(ResponseCodeEnum.USERNAME_OR_PASSWD_ERROR);
		}
		//如果用户不存在，注册
		User user = checkRegister(userRequest);
		//获取用户权限
		buildRoleAndAuth(userRequest, user);
		//响应成功
		return loginSuccess(userRequest,user);
	}
	
	
	/**
	 * 校验是否允许的登录（注册）类型
	 * @param userRequest
	 * @param loginName
	 * @return
	 */
	public void checkLoginType(UserRequest userRequest){
		//校验登录类型
		LoginTypeEnum loginType = LoginTypeEnum.parse(userRequest.getLoginType());
		if(null == loginType){
			throw new DlException(ResponseCodeEnum.NOT_SUPPORT_LOGIN_TYPE);
		}
	}
	
	/**
	 * 根据请求类型构建密码
	 * @param userRequest
	 * @return
	 */
	public UserRequest buildPassword(UserRequest userRequest){
		//根据用户名获取用户信息
		User user = userService.selectByUserName(userRequest.getFullUserName());
		userRequest.setUser(user);
		//分类型构建密码
		LoginTypeEnum loginType = LoginTypeEnum.parse(userRequest.getLoginType());
		String passWd = "";
		if(loginType == LoginTypeEnum.LOGIN_TYPE_USERNAME){ //账户名密码登录
			passWd = user.getPassword();
		} else if(loginType == LoginTypeEnum.LOGIN_TYPE_MOBILE){ //手机号登录 
			passWd = "66"+userRequest.getUserName().substring(7);
		} else if(loginType == LoginTypeEnum.LOGIN_TYPE_WB || loginType == LoginTypeEnum.LOGIN_TYPE_WX 
				|| loginType == LoginTypeEnum.LOGIN_TYPE_QQ){ //微博、微信、QQ
			StringBuffer buffer = new StringBuffer();
			buffer.append(userRequest.getUserName().substring(1));
			buffer.append(userRequest.getTimestamp());
			passWd = MD5Util.string2MD5(buffer.toString(), Constant.PASS_MD5_SALT);
		}
		userRequest.setBuildPassWd(passWd);
		return userRequest;
	}
	
	/**
	 * 校验用户是否注册，如果没有直接注册
	 * @param userRequest
	 * @return
	 */
	public User checkRegister(UserRequest userRequest){
		if(null == userRequest.getUser()){
			User user = registerHandler.register(userRequest);
			userRequest.setUser(user);
		}
		return userRequest.getUser();
	}
	
	public UserRequest buildRoleAndAuth(UserRequest userRequest,User user){
		//如果用户是管理员，查询对应权限
		if(Constant.STATUS_YES_STR.equals(user.getIsManager())){
			//根据用户id，获取所有角色
			List<String> roleList = roleService.getRoleListByUserId(user.getId(),Constant.ROLE_APP);
			userRequest.setRoleList(roleList);
			//根据角色，获取所有权限
			if(null != roleList && roleList.size() > 0){
				List<String> authList = authService.getAuthListByRoleList(roleList);
				userRequest.setAuthList(authList);
			}
		} 
		return userRequest;
	}
	
	/**
	 * 登录成功
	 * @param user
	 * @return
	 */
	public UserResponse loginSuccess(UserRequest userRequest,User user){
		//登录成功，更新token
		User tokenUser = new User();
		tokenUser.setId(user.getId());
		tokenUser.setToken(UIDUtils.generateToken(user));
		userService.update(tokenUser);
		//组装响应参数
		UserResponse response = new UserResponse();
		response.setUserId(user.getId());
		response.setNickName(user.getNickName());
		response.setImgUrl(user.getImgUrl());
		response.setSignature(user.getRemark());
		response.setToken(tokenUser.getToken());
		response.setRemark(user.getRemark());
		response.setAuthList(userRequest.getAuthList());
		//更新缓存
		user.setToken(tokenUser.getToken()); 
		userTemplate.storeUserInfo(null, user.getId(),JSONObject.toJSONString(response));
		return response;
	}
}
