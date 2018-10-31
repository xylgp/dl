package com.dl.common.framework.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import com.dl.common.framework.redis.RedisService;

public class CustomCacheManager implements CacheManager{

	
	private RedisService redisService;
	
	public CustomCacheManager(RedisService redisService) {
		this.redisService = redisService;
	}
	
	@Override
	public <K, V> Cache<K, V> getCache(String paramString) throws CacheException {
		
		return new RedisCache<K,V>(redisService);
	}

}
