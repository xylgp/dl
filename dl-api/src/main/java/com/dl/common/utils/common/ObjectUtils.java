package com.dl.common.utils.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ObjectUtils {
	
	/**
	 * 判断对象是否为空，之校验是否为null
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
	 * 校验是否为空，分类型校验（List/String）
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj)
    {
        if (obj == null) return true;
        if ((obj instanceof List)) return ((List) obj).size() == 0;
        if ((obj instanceof String)) return ((String) obj).trim().equals("");
        return false;
    }
	
	public static boolean isNotEmpty(Object obj)
    {
        return !isEmpty(obj);
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
    
}
