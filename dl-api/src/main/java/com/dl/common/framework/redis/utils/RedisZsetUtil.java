package com.dl.common.framework.redis.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.dl.common.utils.common.JSONUtils;

import redis.clients.jedis.Jedis;

public class RedisZsetUtil {
	
	/**
	 * 
	 * @Title: zAdd 
	 * @Description: 往有序列表中放入元素
	 * --------------若要保证放入对象不重复，则需要保证将该对象转换为字符串后和add存有的数据一致
	 * @param key : String: 有序集合主key 
	 * @param score : double : 指定权重
	 * @param obj :保存的对象 
	 * @return:void 
	 * 
	 */
	public void zAdd(Jedis jedis,String key, double score, Object obj) {
		if(obj == null){
			return;
		}
		jedis.zadd(key, score, JSONUtils.parseObject(obj, String.class));
	}
	/**
	 * 
	 * @Title : zAdd 
	 * @Description : 将map集合中的数据批量存入redis
	 * @param jedis
	 * @param key : String : 主key
	 * @param scoreMembers : Map<String,Double> : 批量插入到redis有序Set中的数据，String 代表序列话为String的数据，Double类型为分值
	 * @return long 新增条数
	 * 
	 */
	public long zAdd(Jedis jedis,String key, final Map<String,Double> scoreMembers) {
		return jedis.zadd(key, scoreMembers);
	}
	
	/**
	 * 
	 * @Title: zrange 
	 * @Description: 根据指定key获取指定范围内的数据
	 * --------------列表为正序--根据score从小到大排序 
	 * @param key : String : 有序集合主key 
	 * @param start : int : 起始索引 
	 * @param end : int : 结束索引 
	 * @param clazz : 泛型类型
	 * @return:List<T> : 返回的List 
	 * 
	 */
	public <T> List<T> zrange(Jedis jedis,String key, int start, int end, Class<T> clazz) {
		List<T> retList = new ArrayList<>();
		Set<String> dataSet = jedis.zrange(key, start, end);
		for (String dataStr : dataSet) {
			retList.add(JSONObject.parseObject(dataStr, clazz));
		}
		return retList;
	}
	
	/**
	 * 
	 * @Title: zrangeAll 
	 * @Description: 根据指定key获取有序set中所有数据
	 * --------------列表为正序--根据score从小到大排序 
	 * @param key : String : 有序集合主key 
	 * @param clazz : 泛型类型 
	 * @return:List<T> 
	 * 
	 */
	public <T> List<T> zrangeAll(Jedis jedis,String key, Class<T> clazz) {
		return zrange(jedis,key, 0, -1, clazz);
	}
	
	/**
	 * 
	 * @Title: zrevrange 
	 * @Description: 根据指定key获取指定范围内的数据
	 * --------------返回反序排列结果--根据score从大到小排列 
	 * @param key : String : 有序集合主key 
	 * @param start : int : 起始索引
	 * @param end : int : 结束索引 
	 * @param clazz : 泛型类型 
	 * @return:List<T> : 返回的List 
	 * 
	 */
	public <T> List<T> zrevrange(Jedis jedis,String key, int start, int end, Class<T> clazz) {
		List<T> retList = new ArrayList<>();
		Set<String> dataSet = jedis.zrevrange(key, start, end);
		for (String dataStr : dataSet) {
			retList.add(JSONObject.parseObject(dataStr, clazz));
		}
		return retList;
	}
	/**
	 * 
	 * @Title: zrangeAll 
	 * @Description: 根据指定key获取有序set中所有数据
	 * --------------返回反序排列结果--根据score从大到小排列 
	 * @param key : String : 有序集合主key 
	 * @param clazz : 泛型类型
	 * @return:List<T> 
	 * 
	 */
	public <T> List<T> zrevrangeAll(Jedis jedis,String key, Class<T> clazz) {
		return zrevrange(jedis,key, 0, -1, clazz);
	}
	
	/**
	 * 
	 * @Title : zrangeByScore 
	 * @Description : 获取指定分值之间的数据 
	 * --------------返回正序排列结果--根据score从小到大排列 
	 * @param jedis : Jedis : jedis客户端
	 * @param key : String : 有序集合主key 
	 * @param minScore : double : 最小分值
	 * @param maxScore : double : 最大分值
	 * @param clazz 泛型class
	 * @return List<T> 
	 * 
	 */
	public <T> List<T> zrangeByScore(Jedis jedis,String key,double minScore,double maxScore,Class<T> clazz){
		List<T> retList = new ArrayList<>();
		Set<String> dataSet = jedis.zrangeByScore(key, minScore, maxScore);
		for(String data : dataSet){
			retList.add(JSONObject.parseObject(data, clazz));
		}
		return retList;
	}
	
	/**
	 * 
	 * @Title : zrangeByScore 
	 * @Description : 获取指定分值之间及指定偏移量和制定查询数量的数据 
	 * --------------返回正序排列结果--根据score从小到大排列 
	 * @param jedis : Jedis : jedis客户端
	 * @param key : String : 有序集合主key 
	 * @param minScore : double : 最小分值
	 * @param maxScore : double : 最大分值
	 * @param maxScore : offset : 查询偏移量
	 * @param maxScore : count : 查询数量
	 * @param clazz 泛型class
	 * @return List<T> 
	 * 
	 */
	public <T> List<T> zrangeByScore(Jedis jedis,String key,double minScore,double maxScore,int offset,int count, Class<T> clazz){
		List<T> retList = new ArrayList<>();
		Set<String> dataSet = jedis.zrangeByScore(key, minScore, maxScore, offset, count);
		for(String data : dataSet){
			retList.add(JSONObject.parseObject(data, clazz));
		}
		return retList;
	}
	
	/**
	 * 
	 * @Title : zrevrangeByScore 
	 * @Description : 获取指定分值之间的数据 
	 * --------------返回反序排列结果--根据score从大到小排列 
	 * @param jedis : Jedis : jedis客户端
	 * @param key : String : 有序集合主key 
	 * @param minScore : double : 最小分值
	 * @param maxScore : double : 最大分值
	 * @param clazz 泛型class
	 * @return List<T> 
	 * 
	 */
	public <T> List<T> zrevrangeByScore(Jedis jedis,String key,double minScore,double maxScore,Class<T> clazz){
		List<T> retList = new ArrayList<>();
		Set<String> dataSet = jedis.zrevrangeByScore(key, maxScore,minScore);
		for(String data : dataSet){
			retList.add(JSONObject.parseObject(data, clazz));
		}
		return retList;
	}
	
	/**
	 * 
	 * @Title : zrevrangeByScore 
	 * @Description : 获取指定分值及指定偏移量和制定查询数量的数据 
	 * --------------返回反序排列结果--根据score从大到小排列 
	 * @param jedis : Jedis : jedis客户端
	 * @param key : String : 有序集合主key 
	 * @param minScore : double : 最小分值
	 * @param maxScore : double : 最大分值
	 * @param maxScore : offset : 查询偏移量
	 * @param maxScore : count : 查询数量
	 * @param clazz 泛型class
	 * @return List<T> 
	 * 
	 */
	public <T> List<T> zrevrangeByScore(Jedis jedis,String key,double minScore,double maxScore,int offset,int count,Class<T> clazz){
		List<T> retList = new ArrayList<>();
		Set<String> dataSet = jedis.zrevrangeByScore(key, maxScore,minScore,offset,count);
		for(String data : dataSet){
			retList.add(JSONObject.parseObject(data, clazz));
		}
		return retList;
	}
	
	/**
	 * 
	 * @Title: zrem 
	 * @Description: 从指定key的有序列表中移除指定元素
	 * @param key : String : 有序集合主key 
	 * @param merbers: 删除的元素集合 
	 * @return void 
	 * 
	 */
	public void zrem(Jedis jedis,String key, Object... merbers) {
		if (merbers == null || merbers.length == 0) {
			return;
		}
		String[] remMerbers = new String[merbers.length];
		for (int i = 0; i < merbers.length; ++i) {
			remMerbers[i] = JSONUtils.parseObject(merbers[i], String.class);
		}
		jedis.zrem(key, remMerbers);
	}
	/**
	 * @Title : zremrangeByRank
	 * @Description : 删除zset列表指定下标范围中的数据
	 * @param jedis : redis客户端
	 * @param key : String : redis中的主Key
	 * @param start : int : 开始下标 
	 * @param end : int : 结束下标
	 */
	public void zremrangeByRank(Jedis jedis, String key, int start, int end){
		if(StringUtils.isEmpty(key)){
			return ;
		}
		jedis.zremrangeByRank(key, start, end);
	}
	/**
	 * @Title : zremrangeByScore
	 * @Description : 删除zset列表指定分值范围中的数据
	 * @param jedis : redis客户端
	 * @param key : String : redis中的主Key
	 * @param start : int : 开始分值(小分值)
	 * @param end : int : 结束分值(大分值)
	 */
	public void zremrangeByScore(Jedis jedis, String key, int start, int end){
		if(StringUtils.isEmpty(key)){
			return ;
		}
		jedis.zremrangeByScore(key, start, end);
	}
	
	/**
	 * 
	 * @Title : zcountAll
	 * @Description : 获取zset列表的数据数量
	 * @param jedis : Jedis : jedis客户端
	 * @param key : String : 有序集合主key 
	 * @return long
	 */
	public long zcountAll(Jedis jedis, String key){
		if(StringUtils.isEmpty(key)){
			return 0;
		}
		return zcount(jedis, key, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	/**
	 * 获取最大分值及最小分值之间的数据数量
	 * @Title : zcount 
	 * @param jedis : Jedis : jedis客户端
	 * @param key : String : 有序集合主key 
	 * @param minScore : double : 最小分值
	 * @param maxScore : double : 最大分值
	 * @return long
	 * 
	 */
	public long zcount(Jedis jedis,String key,double minScore,double maxScore){
		if(StringUtils.isEmpty(key)){
			return 0;
		}
		return jedis.zcount(key, minScore, maxScore);
	}
}
