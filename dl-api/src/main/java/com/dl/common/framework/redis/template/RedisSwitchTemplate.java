package com.dl.common.framework.redis.template;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.dl.common.framework.redis.redisKey.RedisSwitchKey;
import com.dl.common.framework.redis.utils.RedisKeyUtil;
import redis.clients.jedis.Jedis;

@Component
public class RedisSwitchTemplate {
	
	/**
	 * 存储开关
	 * @param switchMap
	 */
	public void storeSwitchDefault(Jedis jedis,Map<String, Object> switchMap){
		for(String key : switchMap.keySet()){
			jedis.hset(RedisKeyUtil.createRedisKeySwitch(RedisSwitchKey.DECRYPT_SWITCH),key,JSONObject.toJSONString(switchMap.get(key)));
		}
	}
	
	/**
	 * 获取开关
	 * @param jedis
	 * @return
	 */
	public Map<String, Object> getSwitchDefault(Jedis jedis){
		Map<String, Object> retMap = new HashMap<>();
		retMap.putAll(jedis.hgetAll(RedisKeyUtil.createRedisKeySwitch(RedisSwitchKey.DECRYPT_SWITCH)));
		return retMap;
	}
}
