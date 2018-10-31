package com.dl.common.framework.redis.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.dl.common.utils.common.CollectionUtil;
import com.dl.common.utils.common.ObjectUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class RedisListUtil {
	/**
	 * 
	 * @Title: rpush
	 * @Description : 将obj压入redis的list中--从右压入-若obj为Collection则使用管道将Collection循环压入
	 * @param jedis : Jedis : redis客户端
	 * @param key : String : 主键
	 * @param obj : Object : 压入的对象
	 */
	public void rpush(Jedis jedis,String key,Object obj){
		if(ObjectUtils.isNull(obj) || StringUtils.isEmpty(key)){
			return ;
		}
		if(obj instanceof Collection){
			Collection<?> coll = (Collection<?>) obj;
			Pipeline pipeline = jedis.pipelined();
			for(Object collValue : coll){
				pipeline.rpush(key, JSONObject.toJSONString(collValue));
			}
			pipeline.sync();
		}else{
			jedis.rpush(key, JSONObject.toJSONString(obj));
		}
	}
	
	/**
	 * @Title: rpush
	 * @Description : 将obj压入redis的list中--从右压入-若obj为Collection则使用管道将Collection循环压入
	 * @param jedis : Jedis : redis客户端
	 * @param key : String : 主键
	 * @param obj : Object : 压入的对象
	 * @param seconds : int : 主键存在的秒数
	 */
	public void rpush(Jedis jedis,String key ,Object obj,int seconds){
		rpush(jedis, key, obj);
		jedis.expire(key, seconds);
	}
	
	/**
	 * @Title: lrangeAll
	 * @Description: 从redis中获取列表的所有数据
	 * @param jedis : Jedis : redis客户端
	 * @param key : String : 主键
	 * @param clazz : Class<T> : 需要转换成对应泛型对象的class
	 * @return List<T> : 泛型列表对象
	 */
	public <T> List<T> lrangeAll(Jedis jedis,String key,Class<T> clazz){
		return lrange(jedis, key, 0, -1, clazz);
	}
	/**
	 * @Title: lrange
	 * @Description: 从redis中获取列表指定坐标区间内的数据
	 * @param jedis : Jedis : redis客户端
	 * @param key : String : 主键
	 * @param start : int : 开始坐标
	 * @param end : int : 结束坐标
	 * @param clazz : Class<T> : 需要转换成对应泛型对象的class
	 * @return List<T> : 泛型列表对象
	 */
	public <T> List<T> lrange(Jedis jedis,String key,int start,int end ,Class<T> clazz){
		List<T> retList = new ArrayList<T>();
		if(StringUtils.isEmpty(key) || ObjectUtils.isNull(clazz)){
			return retList;
		}
		List<String> redisList = jedis.lrange(key, start, end);
		if(CollectionUtil.isEmpty(redisList)){
			return retList;
		}
		for(String value : redisList){
			retList.add(JSONObject.parseObject(value, clazz));
		}
		return retList;
	}
}
