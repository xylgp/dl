package com.dl.common.framework.redis.utils;

import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import com.dl.common.utils.common.JSONUtils;
import com.dl.common.utils.common.MapUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @author Liugp
 * redis管道工具类
 */
public class RedisPipelineUtil {
	
	/**
	 * 使用管道方式批量插入String类型数据
	 * @Title : incr 
	 * @param jedis : jedis客户端
	 * @param datas : incr数据集合列表
	 * @param seconds : 数据有效时间 单位秒
	 * @return void
	 */
	public void setExPipeline(Jedis jedis,Map<String,Object> datas,Integer seconds){
		if(MapUtils.isEmpty(datas)){
			return ;
		}
		Pipeline pipeline = jedis.pipelined();
		for(String key : datas.keySet()){
			pipeline.setex(key, seconds, JSONUtils.parseObject(datas.get(key),String.class));
		}
		pipeline.sync();
	}
	
	/**
	 * 
	 * @Description: 使用redis管道技术进行批量数据插入到redis 
	 * ------------: 使用这种方式对批量数据的插入效率提高非常明显 
	 * ------------: 大数据量的插入 首选该方法,使用此种方式保存的值为字符串
	 * @Title:hSetByPipeLine 
	 * @param key : String : redis map的主key 
	 * @param listMap:Map<String,Object> : 需要进行批量插入的Map集合 
	 * @return void 
	 * 
	 */
	public void hSetByPipeLine(Jedis jedis,String key, Map<String, Object> listMap) {
		if (StringUtils.isEmpty(key) || listMap.isEmpty()) {
			return;
		}
		// 获取jedis管道
		Pipeline pipeLine = jedis.pipelined();
		for (String hashKey : listMap.keySet()) {
			pipeLine.hset(key, hashKey, JSONUtils.parseObject(listMap.get(hashKey), String.class));
		}
		// 同步处理
		pipeLine.sync();
	}
	
	/**
	 * 
	 * @Title : zAdd 
	 * @Description : 将map集合中的数据批量存入redis--使用管道的方式
	 * @param jedis
	 * @param key : String : 主key
	 * @param scoreMembers : Map<String,Double> : 批量插入到redis有序Set中的数据，String 代表序列话为String的数据，Double类型为分值
	 * @return long 新增条数
	 * 
	 */
	public void zAddByPipeLine(Jedis jedis,String key,final Map<String,Double> scoreMembers){
		Pipeline pipeline = jedis.pipelined();
		pipeline.zadd(key, scoreMembers);
		pipeline.sync();
	}
	
	/**
	 * 使用管道方式批量incr
	 * @Title : incr 
	 * @param jedis : jedis客户端
	 * @param datas : incr数据集合列表
	 * @return void
	 * 
	 */
	public void incrPipeline(Jedis jedis,Map<String,Number> datas){
		incrPipeline(jedis, datas, null);
	}
	/**
	 * 使用管道方式批量incr
	 * @Title : incrPipeline 
	 * @param jedis : jedis客户端
	 * @param datas : incr数据集合列表
	 * @param seconds : 有效时间
	 * @return void
	 * 
	 */
	public void incrPipeline(Jedis jedis,Map<String,Number> datas,Integer seconds){
		if(MapUtils.isEmpty(datas)){
			return ;
		}
		Pipeline pipeline = jedis.pipelined();
		for(String key : datas.keySet()){
			Number value = datas.get(key);
			if(value instanceof Double){
				pipeline.incrByFloat(key, value.doubleValue());
			}else{
				pipeline.incrBy(key, value.longValue());
			}
			if(seconds != null && seconds > 0){
				pipeline.expire(key, seconds);
			}
		}
		pipeline.sync();
	}
}
