package com.dl.common.framework.redis.template;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.dl.common.framework.redis.redisKey.RedisConfigKey;
import com.dl.common.framework.redis.redisKey.RedisUserKey;
import com.dl.common.framework.redis.utils.RedisKeyUtil;
import com.dl.common.model.app.req.UserResponse;
import com.dl.common.model.entity.user.User;
import redis.clients.jedis.Jedis;

@Component
public class RedisUserTemplate {
	
	/**
	 * 存储用户信息，并设定存活时间 
	 * @param jedis
	 * @param userId
	 * @param user
	 */
	public void storeUserInfo(Jedis jedis,String userId,String user){
		//获取userInfo指定的存活时间
		String liveTTL = jedis.get(RedisKeyUtil.createRedisKeyConfig(RedisConfigKey.USER_CONFIG,RedisConfigKey.USER_INFO_TTL));
		jedis.set(RedisKeyUtil.createRedisKeyUser(RedisUserKey.USER_INFO,userId),user);
		jedis.expire(RedisKeyUtil.createRedisKeyUser(RedisUserKey.USER_INFO,userId),Integer.parseInt(liveTTL));
	}
	
	/**
	 * 获取用户信息
	 * @param jedis
	 * @param userId
	 * @return
	 */
	public User getUserInfo(Jedis jedis,String userId){
		String userStr = jedis.get(RedisKeyUtil.createRedisKeyUser(RedisUserKey.USER_INFO,userId));
		if(StringUtils.isEmpty(userStr)) return null;
		return JSONObject.parseObject(userStr, User.class);
	}
	
	/**
	 * 获取用户信息
	 * @param jedis
	 * @param userId
	 * @return
	 */
	public UserResponse getUserResponseInfo(Jedis jedis,String userId){
		String userStr = jedis.get(RedisKeyUtil.createRedisKeyUser(RedisUserKey.USER_INFO,userId));
		if(StringUtils.isEmpty(userStr)) return null;
		return JSONObject.parseObject(userStr, UserResponse.class);
	}
	
}
