package com.dl.common.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dl.common.framework.redis.template.RedisUserTemplate;
import com.dl.common.handler.user.LoginHandler;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.model.app.req.UserResponse;
import com.dl.common.model.base.ResponseCodeEnum;
import com.dl.common.model.entity.user.User;
import com.dl.common.utils.common.ResultUtil;

@Controller
@RequestMapping("user")
public class LoginController {
	
	@Autowired
	private LoginHandler loginHandler;
	@Autowired
	private RedisUserTemplate userTemplate;
	
	/**
	 * 用户登录、注册
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login")
	public String login(@RequestBody UserRequest  userRequest,HttpServletRequest request){
		
		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
		UsernamePasswordToken token = new UsernamePasswordToken(JSONObject.toJSONString(userRequest),userRequest.getPasswd());
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		}  catch (IncorrectCredentialsException e) {
			return ResultUtil.error(ResponseCodeEnum.PASSWD_ERROR);
        } catch (ExcessiveAttemptsException e) {
        	return ResultUtil.error(ResponseCodeEnum.LOGIN_ERROR_LIMIT_TIMES);
        } catch (LockedAccountException e) {
        	return ResultUtil.error(ResponseCodeEnum.ACCOUT_LOCK);
        } catch (DisabledAccountException e) {
        	return ResultUtil.error(ResponseCodeEnum.ACCOUT_CANNOT_USE);
        } catch (ExpiredCredentialsException e) {
        	return ResultUtil.error(ResponseCodeEnum.ACCOUNT_EXPIRED);
        } catch (UnknownAccountException e) {
        	return ResultUtil.error(ResponseCodeEnum.USERNAME_OR_PASSWD_ERROR);
        } catch (UnauthorizedException e) {
        	return ResultUtil.error(ResponseCodeEnum.NO_AUTH);
        }
		// 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		// 登陆失败还到login页面
		userRequest = (UserRequest) SecurityUtils.getSubject().getPrincipal();
		User user = loginHandler.checkRegister(userRequest);
		//获取用户权限
		userRequest = loginHandler.buildRoleAndAuth(userRequest,userRequest.getUser());
		UserResponse response = loginHandler.loginSuccess(userRequest, user);
		return ResultUtil.success(response);
//		return msg;
	}
	
	@ResponseBody
	@RequestMapping("loginSuccess")
	public String loginSuccess(){
		 UserRequest userRequest = (UserRequest) SecurityUtils.getSubject().getPrincipal();
		 UserResponse response = loginHandler.loginSuccess(userRequest, userRequest.getUser());
		 return ResultUtil.success(response);
				 
	}
	
	/**
	 * 校验token是否有效，无效需要重新登录
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("refreshToken")
	public String refreshToken(@RequestBody UserRequest userRequest){
		//根据用户id，查询用户缓存
		UserResponse user = userTemplate.getUserResponseInfo(null, userRequest.getId());
		//不存在，需要重新登录
		if(null == user || !user.getToken().equals(userRequest.getToken())){
			return ResultUtil.error(ResponseCodeEnum.NEED_RELOGIN);
		}
		//存在，刷新一下缓存
		userTemplate.storeUserInfo(null, user.getId(), JSONObject.toJSONString(user));
		return ResultUtil.success(user);
	}
	
	
	
	/**
	 * 修改用户信息
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("noAuth")
	public String noAuth(@RequestBody UserRequest userRequest){
		return ResultUtil.error(ResponseCodeEnum.NO_AUTH);
	}
	
	/**
	 * 修改用户信息
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("needLogin")
	public String needLogin(){
		return ResultUtil.error(ResponseCodeEnum.NO_AUTH);
	}
	
}
