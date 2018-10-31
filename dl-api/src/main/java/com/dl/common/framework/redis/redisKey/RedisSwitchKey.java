package com.dl.common.framework.redis.redisKey;

import java.util.HashMap;
import java.util.Map;

public class RedisSwitchKey {
	
	/**开关缓存类主key名*/
	public static String  DL_SWITCH_MAP = "DL_SWITCH_MAP";
	
	//----------------------------------------------------------------------------------------------------//
	public static String DECRYPT_SWITCH = "DECRYPT_SWITCH"; //头部加密传输解密开关
	public static String HEADER_ISNULL_SWITCH = "HEADER_ISNULL_SWITCH";//头部加密参数非空判断
	public static String HEADER_SIGN_SWITCH = "HEADER_SIGN_SWITCH";//头部加密Sign校验
	
	//redis获取不到值，添加默认值
	public static Map<String, Object> getSwitchMapDefault(){
		Map<String, Object> switchMap = new HashMap<String, Object>();
		switchMap.put("DECRYPT_SWITCH", true);//如果缓存不存在，默认开启
		switchMap.put("HEADER_ISNULL_SWITCH", true);//如果缓存不存在，默认开启
		switchMap.put("HEADER_SIGN_SWITCH", true);//如果缓存不存在，默认开启
		return switchMap;
	}
	
	/**
	 * 获取开关值，如果map中不存在，使用默认值
	 * @param map
	 * @param switchKey
	 * @param defaultSwitchKey
	 * @return
	 */
	public static boolean getSwitch(Map<String, Object> map,String switchKey,boolean defaultSwitchKey){
		try {
			if(map.containsKey(switchKey)){
				return (Boolean) map.get(switchKey);
			}else{
				return defaultSwitchKey;
			}
		} catch (Exception e) {
			return defaultSwitchKey;
		}
	}
	
}
