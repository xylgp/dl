package com.dl.common.utils.common;

public class JSONUtils {
	
	/**
	 * 将obj转化为class对应的泛型对象
	 * @param obj
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T parseObject(Object obj,Class<T> clazz){
		if(obj == null){
			return null;
		}
		try {
			if(obj instanceof String){
				obj = com.alibaba.fastjson.JSONObject.parse(obj.toString());
			}
			String jsonStr = com.alibaba.fastjson.JSONObject.toJSONString(obj);
			return com.alibaba.fastjson.JSONObject.parseObject(jsonStr,clazz);
		} catch (Exception e) {
			return (T)obj;
		}
	}
}
