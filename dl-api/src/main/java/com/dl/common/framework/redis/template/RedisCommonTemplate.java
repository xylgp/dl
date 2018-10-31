package com.dl.common.framework.redis.template;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisCommonTemplate {

	public void StoreKey(Jedis jedis,int index,String key,String value){
		jedis.select(index);
		jedis.set(key, value);
	}
	
	public Object getValue(Jedis jedis,int index,String key){
		jedis.select(index);
		return jedis.get(key);
	}
}
