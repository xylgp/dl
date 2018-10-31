package com.dl.common.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dl.common.model.app.req.UserRequest;
import com.dl.common.service.user.UserService;
import com.dl.common.utils.common.ResultUtil;
@Controller
@RequestMapping("user")
public class UserInfoController {

	@Autowired
	private UserService userService;
	
	/**
	 * 修改用户信息
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateInfo")
	public String updateInfo(@RequestBody UserRequest userRequest){
		userService.updateUserInfo(userRequest);
		return ResultUtil.success();
	}
	
	/**
	 * 查询用户信息
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("userInfo")
	public String getUserInfo(@RequestBody UserRequest userRequest){
		return ResultUtil.success(userService.getById(userRequest.getUserId()));
	}
}
