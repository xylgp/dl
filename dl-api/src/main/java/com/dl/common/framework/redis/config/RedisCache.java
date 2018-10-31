package com.dl.common.framework.redis.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.dl.common.framework.redis.handlers.RedisHandlerAbstarct;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RedisCache {
	
	/**
	 * 缓存的key值
	 */
	String key();
	
	/**
	 * 操作类型 :类型参考HandlerEnum枚举
	 */
	String handlerType();
	
	/**
	 * 缓存执行类
	 * @return
	 */
	String cacheHandlerName() default "";
	
	/**
	 * 缓存执行类class 
	 * @throws
	 */
	Class<?> cacheHandlerClass() default RedisHandlerAbstarct.class;
}
