package com.dl.common.framework.redis.utils;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisCommonUtil {
	
	/**
	 * @Description: 根据key前缀获取key的set列表值
	 * @param jedis
	 * @param keyPrefix
	 * @return
	 */
	public Set<String> keysByPrefix(Jedis jedis,String keyPrefix){
		return jedis.keys(keyPrefix + "*");
	}
	
	/**
	 * 指定key存活时间
	 * @param key
	 * @param expire
	 */
	public void expireKey(Jedis jedis,String key,int expire){
		jedis.expire(key, expire);
	}
	
	/**
	 * 获取当前key剩余存活时间
	 * 
	 * @param key
	 * @return
	 */
	public int getKeyTtl(Jedis jedis,String key) {
		return jedis.ttl(key).intValue();
	}
	
	/**
	 * 判断key是否存在
	 * @param key
	 * @return
	 */
	public boolean checkIsExit(Jedis jedis,String key) {
		return jedis.exists(key);
	}
	
	/**
	 * 删除key
	 * @param key
	 */
	public void removeKey(Jedis jedis,String key) {
		jedis.del(key);
	}
	
	/**
	 * 删除模糊查询到的所有key
	 * @param key
	 */
	public void removeAllKey(Jedis jedis,String key) {
		Set<String> set = jedis.keys(key + "*");
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String keyStr = it.next();
			jedis.del(keyStr);
		}
	}
}
