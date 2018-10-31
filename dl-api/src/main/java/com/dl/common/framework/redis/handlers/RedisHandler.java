package com.dl.common.framework.redis.handlers;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * redis缓存基础助手接口--所有redis助手类的最终父接口
 * @author Levi.liu
 *
 */
public interface RedisHandler {
	
	/**
	 * 执行redis相关操作的核心方法 
	 * @param joinPoint : ProceedingJoinPoint : 切入点对象
	 * @return Object 
	 * @throws 
	 */
	Object process(ProceedingJoinPoint joinPoint) throws Throwable;
}
