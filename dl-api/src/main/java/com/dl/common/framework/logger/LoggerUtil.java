package com.dl.common.framework.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);
	
	public static void debug(String message){
		logger.debug(message);
	}
	
	public static void debug(String message,Exception e){
		logger.debug(message, e);
	}
	
	public static void info(String message){
		logger.info( message);
	}
	
	public static void info(String message,Exception e){
		logger.info( message, e);
	}
	
	public static void error(String message){
		logger.error(message);
	}
	
	public static void error(String message,Exception e){
		logger.error( message, e);
	}
}
