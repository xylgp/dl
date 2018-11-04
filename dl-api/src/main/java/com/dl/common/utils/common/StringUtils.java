package com.dl.common.utils.common;

/**
 * String 工具类
 * @author Levi.liu
 *
 */
public class StringUtils {
	
	/**
	 * 批量校验字段非空
	 * @param strings
	 * @return
	 */
	public static boolean isEmpty(String...strings){
		for(String str : strings){
			if(StringUtils.isEmpty(str)){
				return false;
			}
		}
		return true;
	}
	
	
	
}
