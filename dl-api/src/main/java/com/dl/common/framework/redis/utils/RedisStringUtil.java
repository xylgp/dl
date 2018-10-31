package com.dl.common.framework.redis.utils;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dl.common.utils.common.ObjectUtils;

import redis.clients.jedis.Jedis;

public class RedisStringUtil {
	
	/**
	 * 存储String：指定存活时间
	 * @param key
	 * @param value
	 * @param times 存活时间（s）
	 */
	public void insertString(Jedis jedis,String key, String value, int times) {
		jedis.setex(key, times, value);
	}
	
	/**
	 * 存储String:默认永久存在
	 * @param key
	 * @param value
	 */
	public void insertString(Jedis jedis,String key, String value) {
		jedis.set(key, value);
	}
	
	/**
	 * String +1
	 * 如果键不存在，则会创建并且初始化为1
	 * @param key
	 * @param map
	 */
	public Long incrString(Jedis jedis,String key) {
		return jedis.incr(key);
	}
	
	/**
	 * 批量存储String
	 * 
	 * @param key
	 * @param map
	 */
	public void batchInsertString(Jedis jedis,Map<String, Object> map) {
		for (String key : map.keySet()) {
			if (map.get(key).toString().equals("")) {
				jedis.set(key, "");
			} else {
				jedis.set(key, map.get(key).toString());
			}
		}
	}
	
	/**
	 * 获取单个String
	 * 
	 * @param key
	 * @return
	 */
	public String getString(Jedis jedis,String key) {
		return jedis.get(key);
	}
	
	/**
	 * <p>
	 * 增长键 原基础上加上value 若键不存在则创建key并将其值初始化为0 同时加上value
	 * </p>
	 * @Title : incr 
	 * @param jedis : jedis客户端
	 * @param key : String : 有序集合主key 
	 * @param value : Double : 增加的值
	 * @param seconds : Integer : 存活的秒数以秒为单位 大于0即为存活的秒数
	 * @return Double : 返回增加后的值
	 * 
	 */
	public Double incr(Jedis jedis,String key ,Double value,Integer seconds){
		if(StringUtils.isEmpty(key) || ObjectUtils.isNull(value)){
			return null;
		}
		Double retValue = jedis.incrByFloat(key, value);
		if(seconds != null && seconds > 0){
			jedis.expire(key, seconds);
		}
		return retValue;
	}
	
	/**
	 * <p>
	 * 增长键 原基础上加上value 若键不存在则创建key并将其值初始化为0 同时加上value
	 * </p>
	 * @Title : incr 
	 * @param jedis : jedis客户端
	 * @param key : String : 有序集合主key 
	 * @param value : Long : 增加的值
	 * @param seconds : Integer : 存活的秒数以秒为单位 大于0即为存活的秒数
	 * @return Long : 返回增加后的值
	 * 
	 */
	public Long incr(Jedis jedis,String key,Long value,Integer seconds){
		if(StringUtils.isEmpty(key) || ObjectUtils.isNull(value)){
			return null;
		}
		Long retValue = jedis.incrBy(key, value);
		if(seconds != null && seconds > 0){
			jedis.expire(key, seconds);
		}
		return retValue;
	}
	
	/**
	 * 增长键 原基础上加上value 若键不存在则创建key并将其值初始化为0 同时加上value
	 * @Title : incr 
	 * @param jedis : jedis客户端
	 * @param key : String : 有序集合主key 
	 * @param seconds : Integer : 存活的秒数以秒为单位 大于0即为存活的秒数
	 * @return Long : 返回增加后的值
	 * 
	 */
	public Long incr(Jedis jedis ,String key,Integer seconds){
		if(StringUtils.isEmpty(key)){
			return null;
		}
		Long retValue = jedis.incr(key);
		if(seconds != null && seconds > 0){
			jedis.expire(key, seconds);
		}
		return retValue;
	}
	
	/**
	 * @Title: setNx
	 * @Description: 设置nxValue到redis中 如果存在返回0  不存在返回0
	 * @param jedis : Jedis : redis客户端
	 * @param nxKey : String : 主键
	 * @param nxValue : String : 值
	 * @param seconds 有效的秒数
	 * @return Long : 1 添加成功 : 0 添加失败 
	 */
	public Long setNx(Jedis jedis,String nxKey,String nxValue,int seconds){
		Long result = jedis.setnx(nxKey, nxValue);
		jedis.expire(nxKey, seconds);
		return result;
	}
}
