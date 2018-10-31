package com.dl.common.framework.redis.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dl.common.framework.redis.RedisService;
import redis.clients.jedis.Jedis;

@Aspect
@Component
public class RedisAspect {
	
	@Autowired
	RedisService redisService;
	
	@Pointcut("execution(* com.dl.common.framework.redis.template..*.*(..))")
    public void redisAspect(){    }
	
	@Around("redisAspect()")
	public Object around(JoinPoint joinPoint) {
		Jedis jedis = null;
		try {
			Object[] args = joinPoint.getArgs(); 
			jedis = redisService.getJedis();
			args[0] = jedis;
			return ((ProceedingJoinPoint) joinPoint).proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		} finally {
			redisService.releaseJedis(jedis);
		}
	}
	
	
	
	
	
	
	/*@Pointcut("execution (* com.guduo..dao..*.*(..)) "
			+ "&& !execution(* com.guduo.common.core.dao.BaseDaoImpl.getProxy(..))" 
			+ ")")
	public void aroundReidsDaoLogic() { }
	
	@Around("aroundReidsDaoLogic()")
	public Object aroundReidsDaoLogic(ProceedingJoinPoint point) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) point.getSignature();
		Method method = methodSignature.getMethod();
		
//		如果实现类方法上存在RedisCache注解，则直接返回交给redisCacheAnnotationPoint切面处理
		if(method.isAnnotationPresent(RedisCache.class)){
			return point.proceed();
		}
//		如果该方法上不存在RedisCache注解则执行原缓存处理逻辑
		try {
			Object reback = null;
			// 缓存开关打开，且方法标注缓存注解
			RedisCache cache = (RedisCache) AnnotationUtil.getAnnotationForMethod(method, RedisCache.class);
			if (CacheConfig.isCache && null != cache) {
				// 获取注解相关信息
				String type = cache.handlerType();// 获取操作类型
				String cacheHandlerName = cache.cacheHandlerName();// 获取处理类
				String key = cache.key();
				Class<?> cla = Class.forName(cacheHandlerName);
				Method[] methods = cla.getMethods();
				for (Method process : methods) {
					if (process.getName().toString().equals("process")) {
						reback = process.invoke(cla.newInstance(), point.getArgs(), method, point.getTarget(), type,
								key);
						break;
					}
				}
				return reback;
			} else {
				return point.proceed();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return point.proceed();
		}
	}*/
}
