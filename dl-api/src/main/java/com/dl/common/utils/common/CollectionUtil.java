package com.dl.common.utils.common;

import java.util.Collection;

public class CollectionUtil {
	
	/**
	 * @Title : isEmpty 
	 * @Description : 是否为空集合
	 * @param Collection
	 * @return boolean : 空集合 : true 非空:false 
	 * @throws
	 */
	public static boolean isEmpty(Collection<?> collection){
		if(collection == null || collection.size() == 0){
			return true;
		}
		return false;
	}
}
