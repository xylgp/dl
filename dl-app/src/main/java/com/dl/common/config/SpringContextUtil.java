package com.dl.common.config;

import java.util.Locale;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext contex) throws BeansException {
		context = contex;
	}

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	public static <T> T getBean(String beanName, Class<T> clazz) {
		return context.getBean(beanName, clazz);
	}

	public static String getMessage(String key) {
		return context.getMessage(key, null, Locale.getDefault());
	}
}
