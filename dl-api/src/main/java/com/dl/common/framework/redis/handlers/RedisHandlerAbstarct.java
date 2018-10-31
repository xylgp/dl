package com.dl.common.framework.redis.handlers;

import java.lang.reflect.Method;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.dl.common.framework.redis.config.HandlerType;
import com.dl.common.framework.redis.config.RedisCache;

public abstract class RedisHandlerAbstarct implements RedisHandler{
	
	/**目标方法*/
	protected Method targetMethod;
	/**目标方法的参数值*/
	protected Object[] targetArgs;
	/**redisCache注解类*/
	protected RedisCache redisCache;
	/**目标方法的切入点*/
	protected ProceedingJoinPoint joinPoint;
	/**保存到redis里面的主Key--需要子类根据实际情况去赋值*/
	protected String redisPrimaryKey;
	
	@Override
	public final Object process(ProceedingJoinPoint joinPoint) throws Throwable{
		try {
			//初始化属性，必须最开始的时候执行
			initAttr(joinPoint);
		} catch (Exception e) {
			return joinPoint.proceed();
		}
		return null;
	}
	
	/**
	 * 初始化属性
	 */
	private void initAttr(ProceedingJoinPoint joinPoint){
		this.joinPoint = joinPoint;
		//1、初始化基础属性
		initBaseAttr();
		//2、初始化其余对象
		initOtherObj();
		//3、初始化key
		initRedisPrimaryKey();
		//4、初始化handler类型
		
	}
	
	/**
	 * 初始化基础属性
	 */
	private void initBaseAttr(){
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		this.targetArgs = joinPoint.getArgs();
		this.targetMethod = methodSignature.getMethod();
		this.redisCache = targetMethod.getAnnotation(RedisCache.class);
	}
	
	/**
	 * 初始化其他对象属性
	 */
	protected void initOtherObj() {
		initExtractObj();
	}
	
	protected void initExtractObj() {}
	
	/**
	 * 初始化redis的主Key方法---由子类实现--统一由RedisUtils去创建各个主题的redis主key
	 */
	protected abstract void initRedisPrimaryKey();
	
	/**
	 * 执行操作
	 * @return
	 * @throws Throwable
	 */
	public final Object doProcess() throws Throwable{
		if(HandlerType.DAO_INSERT.equals(this.redisCache.handlerType())){
			return doInsert();
		}else if(HandlerType.DAO_DELETE.equals(this.redisCache.handlerType())){
			return doDelete();
		}else if(HandlerType.DAO_UPDATE.equals(this.redisCache.handlerType())){
			return doUpdate();
		}else if(HandlerType.DAO_SEARCH.equals(this.redisCache.handlerType())){
			return doSearch();
		}else if(HandlerType.DAO_BATCH_UPDATE.equals(this.redisCache.handlerType())){
			return doBatchUpdate();
		}else if(HandlerType.DAO_BATCH_INSERT.equals(this.redisCache.handlerType())){
			return doBatchInsert();
		}
		return proceedTargetMethod();
	}
	
	/**
	 * 将obj放入redis中
	 * @param obj
	 */
	protected abstract void insertObjToRedis(Object obj);
	
	/**
	 * 插入方法执行结果到redis中 --并返回目标方法执行结果
	 * @return Object  
	 * @throws
	 */
	public Object insertMethodResultToRedis(){
		Object result = proceedTargetMethod();
		if(result != null){
			insertObjToRedis(result);
		}
		return result;
	}
	
	/**
	 * 返回目标方法执行的结果
	 * @return
	 */
	protected Object proceedTargetMethod(){
		try {
			return joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 执行查询缓存逻辑 : 所有子类可重写该方法
	 * @return Object 
	 * @throws
	 */
	protected Object doSearch(){
		return proceedTargetMethod();
	}
	
	/**
	 * 执行查询缓存逻辑 : 所有子类可重写该方法
	 * @throws Throwable 
	 * @return Object 
	 * @throws
	 */
	protected Object doUpdate(){
		return proceedTargetMethod();
	}
	
	/**
	 * 执行查询缓存逻辑 : 所有子类可重写该方法
	 * @throws Throwable 
	 * @return Object 
	 * @throws
	 */
	protected Object doInsert(){
		return proceedTargetMethod();
	}
	
	/**
	 * 执行批量插入缓存逻辑 : 所有子类可重写该方法
	 * @throws Throwable 
	 * @return Object 
	 * @throws
	 */
	protected Object doBatchInsert(){
		return proceedTargetMethod();
	}
	
	/**
	 * 执行批量更新缓存逻辑 : 所有子类可重写该方法
	 * @throws Throwable 
	 * @return Object 
	 * @throws
	 */
	protected Object doBatchUpdate(){
		return proceedTargetMethod();
	}
	
	/**
	 * 执行查询缓存逻辑 : 所有子类可重写该方法
	 * @throws Throwable 
	 * @return Object 
	 * @throws
	 */
	protected Object doDelete(){
		return proceedTargetMethod();
	}
	
	/**
	 * 从目标参数中获取泛型对象
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getTObjFromTargetArgs(Class<T> clazz) {
		if(ArrayUtils.isEmpty(targetArgs)){
			return null;
		}
		for(Object arg : targetArgs){
			if(arg.getClass().equals(clazz)){
				return (T) arg;
			}
		}
		return null;
	}
}
