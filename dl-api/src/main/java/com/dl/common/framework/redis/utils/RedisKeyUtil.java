package com.dl.common.framework.redis.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.dl.common.framework.redis.redisKey.RedisCommonKey;

public class RedisKeyUtil {
	
	private static String REDIS_CONNECTOR_CHAR = ":";
	
	/**
	 * 构建公共类缓存key
	 * @param keyAssembly : String... 需要进行组装的key组件数组
	 * @return:String : 组装好的key
	 */
	public static final String createRedisKeyCommon(String ... keyAssemblys){
		return createRedisKey(RedisCommonKey.MODULE_PREFIX_COMMON,keyAssemblys);
	}
	
	/**
	 * 构建故事类缓存key
	 * @param keyAssembly : String... 需要进行组装的key组件数组
	 * @return:String : 组装好的key
	 */
	public static final String createRedisKeyStory(String ... keyAssemblys){
		return createRedisKey(RedisCommonKey.MODULE_PREFIX_STORY,keyAssemblys);
	}
	
	/**
	 * 构建用户类缓存key
	 * @param keyAssembly : String... 需要进行组装的key组件数组
	 * @return:String : 组装好的key
	 */
	public static final String createRedisKeyUser(String ... keyAssemblys){
		return createRedisKey(RedisCommonKey.MODULE_PREFIX_USER,keyAssemblys);
	}
	
	/**
	 * 构建配置类缓存key
	 * @param keyAssembly : String... 需要进行组装的key组件数组
	 * @return:String : 组装好的key
	 */
	public static final String createRedisKeyConfig(String ... keyAssemblys){
		return createRedisKey(RedisCommonKey.MODULE_PREFIX_CONFIG,keyAssemblys);
	}
	
	/**
	 * 构建开关类缓存key
	 * @param keyAssemblys
	 * @return
	 */
	public static final String createRedisKeySwitch(String ... keyAssemblys){
		return createRedisKey(RedisCommonKey.MODULE_PREFIX_SWITCH,keyAssemblys);
	}
	
	/**
	 * 生成 redis key 的核心方法
	 * @Description:  topicPrefix:keyAssemblys[0]:keyAssemblys[1]:...:keyAssemblys[n]
	 * @param topicPrefix : 主题前缀
	 * @param keyAssemblys :  需要进行组装的key组件数组
	 * @return:String : 组装好的key
	 */
	private static final String createRedisKey(String topicPrefix,String ... keyAssemblys){
		if(StringUtils.isEmpty(topicPrefix) || ArrayUtils.isEmpty(keyAssemblys)){
			return null;
		}
		int arrLength = keyAssemblys.length;
		StringBuffer retStrBuf = new StringBuffer(topicPrefix.toUpperCase());
		for(int i = 0 ; i < arrLength ; ++i){
			if(StringUtils.isNotEmpty(keyAssemblys[i])){
				retStrBuf.append(REDIS_CONNECTOR_CHAR).append(keyAssemblys[i].toUpperCase());
			}
		}
		return retStrBuf.toString();
	}
}
