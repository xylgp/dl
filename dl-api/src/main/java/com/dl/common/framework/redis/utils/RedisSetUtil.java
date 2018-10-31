package com.dl.common.framework.redis.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.dl.common.utils.common.CollectionUtil;
import com.dl.common.utils.common.ObjectUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class RedisSetUtil {
	/**
	 * @Title: sadd
	 * @Description : 将obj压入redis的Set中--若obj为Collection则使用管道将Collection循环压入
	 * @param jedis : Jedis : redis客户端
	 * @param key : String : 主键
	 * @param obj : Object : 压入的对象
	 */
	public void sadd(Jedis jedis,String key ,Object obj){
		if(ObjectUtils.isNull(obj) || StringUtils.isEmpty(key)){
			return ;
		}
		if(obj instanceof Collection){
			Collection<?> coll = (Collection<?>) obj;
			Pipeline pipeline = jedis.pipelined();
			for(Object collValue : coll){
				pipeline.sadd(key, JSONObject.toJSONString(collValue));
			}
			pipeline.sync();
		}else{
			jedis.sadd(key, JSONObject.toJSONString(obj));
		}
	}
	/**
	 * @Title: sadd
	 * @Description : 将obj压入redis的Set中--若obj为Collection则使用管道将Collection循环压入
	 * @param jedis : Jedis : redis客户端
	 * @param key : String : 主键
	 * @param obj : Object : 压入的对象
	 * @param seconds : int : 主键存在的秒数
	 */
	public void sadd(Jedis jedis,String key ,Object obj , int seconds){
		sadd(jedis, key, obj);
		jedis.expire(key, seconds);
	}
	/**
	 * @Title: smembers
	 * @Description: 从redis中获取set集合的所有成员
	 * @param jedis : Jedis : redis客户端
	 * @param key : String : 主键
	 * @param clazz : Class<T> : 需要转换成对应泛型对象的class
	 * @return List<T> : 泛型列表对象
	 */
	public <T> List<T> smembers(Jedis jedis,String key,Class<T> clazz){
		List<T> retList = new ArrayList<T>();
		if(StringUtils.isEmpty(key) || ObjectUtils.isNull(clazz)){
			return retList;
		}
		Set<String> redisSet = jedis.smembers(key);
		if(CollectionUtil.isEmpty(redisSet)){
			return retList;
		}
		for(String value : redisSet){
			retList.add(JSONObject.parseObject(value, clazz));
		}
		return retList;
	}
}
