package com.dl.common.framework.redis.aspect;

public class CacheConfig {
	
	//缓存开关
	public static boolean isCache=true;

	public static boolean isCache() {
		return isCache;
	}

	public static void setCache(boolean isCache) {
		CacheConfig.isCache = isCache;
	}
}
