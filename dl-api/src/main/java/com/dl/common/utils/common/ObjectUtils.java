package com.dl.common.utils.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ObjectUtils {
	
	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return 对象为空返回true 否则返回false
	 */
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	/**
	 * 判断对象是否非空
	 * @param obj
	 * @return 对象不为空返回true 否则返回false
	 */
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}
	/**
	 * 序列化
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		if(isNull(object)){
			return null;
		}
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(isNotNull(oos)){
					oos.close();
				}
				if(isNotNull(baos)){
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 反序列化
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		if(isNull(bytes)){
			return null;
		}
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(isNotNull(ois)){
					ois.close();
				}
				if(isNotNull(bais)){
					bais.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 *	
	 * @Title: getAnnotationForMethod
	 * @Description: 获取方法上的注解 若该方法的注解在其实现接口的方法上，则将该接口放于首位
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
	 * 
	 * @Title: getAnnotationForMethod
	 * @Description: 迭代获取指定方法上的指定注解
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
	
	/** 
     * 取得指定类路径下的所有类 
     * @param cls 
     * @throws IOException 
     * @throws ClassNotFoundException 
     */  
    public static List<Class<?>> getClasses(Class<?> cls) throws IOException, ClassNotFoundException{  
        String pk = cls.getPackage().getName();  
        String path = pk.replace('.', '/');  
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();  
        URL url = classloader.getResource(path);  
        return getClasses(new File(url.getFile()), pk);  
    }  
    
    /** 
     * 迭代查找类 
     * @param dir 
     * @param pk 
     * @return 
     * @throws ClassNotFoundException 
     */  
    private static List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException {  
        List<Class<?>> classes = new ArrayList<Class<?>>();  
        if (!dir.exists()) {  
            return classes;  
        }  
        for (File f : dir.listFiles()) {  
            if (f.isDirectory()) {  
                classes.addAll(getClasses(f, pk + "." + f.getName()));  
            }  
            String name = f.getName();  
            if (name.endsWith(".class")) {  
                classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));  
            }  
        }  
        return classes;  
    } 
}
