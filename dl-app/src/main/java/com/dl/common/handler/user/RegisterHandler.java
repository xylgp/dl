package com.dl.common.handler.user;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dl.common.framework.redis.redisKey.RedisConfigKey;
import com.dl.common.framework.redis.template.RedisConfigTemplate;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.model.entity.user.User;
import com.dl.common.model.enums.LoginTypeEnum;
import com.dl.common.service.user.UserService;
import com.dl.common.utils.common.UIDUtils;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RedisConfigTemplate configTemplate;
	
	public User register(UserRequest userRequest){
		User user = initUser(userRequest);
		user.setLoginName(LoginTypeEnum.buildLoginName(userRequest.getLoginType(), userRequest.getUserName()));
		if(LoginTypeEnum.LOGIN_TYPE_USERNAME.type == userRequest.getLoginType()){
			user.setPassword(user.getPassword());
		}
		userService.insert(user);
		return user;
	}
	
	/**
	 * 初始化user
	 * @param imgUrl
	 * @return
	 */
	private User initUser(UserRequest userRequest){
		User user = new User();
		user.setId(UIDUtils.generateID());
		user.setNickName(userRequest.getNickName());
		user.setSex(userRequest.getSex());
		user.setRemark(userRequest.getRemark());
		if(StringUtils.isEmpty(userRequest.getImgUrl())){
			user.setImgUrl(configTemplate.getSysConfig(null, RedisConfigKey.USER_CONFIG,RedisConfigKey.USER_DEF_IMG));
		} else {
			user.setImgUrl(userRequest.getImgUrl());
		}
		user.setFollowCount("0");
		user.setFansCount("0");
		user.setCreateTime(new Date());
		return user;
	}
}
