package com.dl.common.framework.exception;

import javax.servlet.ServletRequest;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.dl.common.framework.logger.LoggerUtil;
import com.dl.common.model.base.ResponseCodeEnum;
import com.dl.common.utils.common.ResultUtil;

@Aspect
@Component
public class ExceptionAspect {
	
	Logger logger = Logger.getLogger(ExceptionAspect.class);
	
	@Pointcut("execution(* com.dl.common.controller..*.*(..))")
	public void exceptionAspect(){} 
	
	@Before("exceptionAspect()")
	public void before(JoinPoint joinPoint){
		LoggerUtil.info(buildInfo(joinPoint));
	}
	@Around("exceptionAspect()")
	public Object around(JoinPoint joinPoint) {
		try {
			return ((ProceedingJoinPoint) joinPoint).proceed();
		} catch (Throwable e) {
			logger.error("around 测试捕获异常",e);
			if(e instanceof DlException){//自定义异常
				DlException dlException = (DlException)e;
				return ResultUtil.error(dlException.getErrorCode());
			} else if(e instanceof DuplicateKeyException){//唯一索引校验不通过，重复操作
				return ResultUtil.error(ResponseCodeEnum.MYSQL_REPEAT_INSERT);
			}
			return ResultUtil.error();
		}
	}
    
    private String buildInfo(JoinPoint joinPoint){
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		StringBuffer buffer = new StringBuffer();
		for(Object obj : args){
			if(obj instanceof ServletRequest ){
				continue;
			}
			buffer.append(JSONObject.toJSONString(obj));
		}
		String req = buffer.toString();
		return "["+className+"]"+"["+methodName+"]"+"request param:"+req;
	}
    
}
