package com.dl.common.config;

import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.PropertyResourceBundle;
import com.dl.common.framework.logger.LoggerUtil;

public class MsgTemplateProps {
	
	public static String UPLOAD_STORY; //被关注人发布故事，给关注人发布消息
	
	/**
	 * 加载系统配置项
	 */
	public static void loadDefinitions() {
		try {
			InputStreamReader fis =new InputStreamReader(MsgTemplateProps.class.getClassLoader().getResourceAsStream("properties/msgTemplate.properties"),"UTF-8");
			PropertyResourceBundle props = new PropertyResourceBundle(fis);

			Class<?> clazz = MsgTemplateProps.class;
			Field[] fields = clazz.getDeclaredFields();
			Object obj = clazz.newInstance();
			for (Field f : fields) {
				f.set(obj, props.getString(f.getName()));
			}

			props = null;
			fis.close();
			fis = null;
		} catch (Exception e) {
			LoggerUtil.error("props >> Read config info error", e);
		}
	}
	
	public static String getValue(String url){
		try {
			String ul = url.replaceAll("/", "_");
			Field[] fields = MsgTemplateProps.class.getDeclaredFields();
			for(Field field : fields){
				if(ul.toUpperCase().endsWith(field.getName())){
					return (String) field.get(new ParamProps());
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 打印配置项
	 */
	public static void print() {
		StringBuilder builder = new StringBuilder("-----------------------------------------------------------\n");
		try {
			Class<?> clazz = MsgTemplateProps.class;
			Field[] fields = clazz.getDeclaredFields();
			Object obj = clazz.newInstance();
			for (Field f : fields) {
				builder.append(f.getName() + "=" + f.get(obj) + System.lineSeparator());
			}
			builder.append("-----------------------------------------------------------");
		} catch (Exception e) {
			LoggerUtil.error("props >> print configuration error", e);
		}
		LoggerUtil.info(builder.toString());
	}
}
