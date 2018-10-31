package com.dl.common.utils.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 注解工具类
 * @author Levi.liu
 *
 */
public class AnnotationUtil {
	
	/**
	 * 获取方法上的注解 若该方法的注解在其实现接口的方法上，则将该接口放于首位
	 * @param method
	 * @param annotationClass
	 * @return:annotation
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	public static Annotation getAnnotationForMethod(Method method,Class annotationClass) {
		if(method == null){
			return null;
		}
		return getAnnotationForMethod(method, method.getDeclaringClass(), annotationClass);
	}
	
	/**
	 * 迭代获取指定方法上的指定注解
	 * @param method
	 * @param currentClass
	 * @param annotationClass
	 * @return:Annotation
	 * @throws
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Annotation getAnnotationForMethod(Method method,Class<?> currentClass,Class annotationClass) {
		try {
			if(ObjectUtils.isNull(method) || currentClass == null){
				return null;
			}
//			首先获取当前方法上的注解存在直接返回
			Annotation annotation = method.getAnnotation(annotationClass);
			if(annotation != null){
				return annotation;
			}
//			获取目标类实现的接口数组
			Class<?> [] targetInfClazz = currentClass.getInterfaces();
//			判断是否有实现的接口没有实现直接返回
			if(targetInfClazz.length > 0){
//				给迭代类赋值为第一个接口,避免循环接口，提高效率，需要将有注解的接口放在实现类的首位
				currentClass = targetInfClazz[0];
			}else{
				return annotation;
			}
//			遍历接口
			for(Class<?> tempClass : targetInfClazz){
//				根据方法签名获取目标接口中的对应的方法
				Method superMethod = tempClass.getMethod(method.getName(), method.getParameterTypes());
				if(ObjectUtils.isNotNull(superMethod)){
//					获取该方法指定注解类的注解
					annotation = superMethod.getAnnotation(annotationClass);
//					存在直接返回
					if(annotation != null){
						return annotation;
					}
				}
			}
//			继续迭代
			return getAnnotationForMethod(method, currentClass,annotationClass);
		} catch (Exception e) {
			if(e instanceof NoSuchMethodException){
				
			}else{
				e.printStackTrace();
			}
			return null;
		}
	}
}
