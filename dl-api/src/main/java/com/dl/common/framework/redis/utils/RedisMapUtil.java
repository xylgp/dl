package com.dl.common.framework.redis.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.dl.common.utils.common.CollectionUtil;
import com.dl.common.utils.common.JSONUtils;
import com.dl.common.utils.common.ObjectUtils;

import redis.clients.jedis.Jedis;

public class RedisMapUtil {
	
	/**
	 * 存储Hash:指定存活时间
	 * @param key
	 * @param map
	 * @param times:存活时间（s）
	 */
	public void insertHash(Jedis jedis,String key, Map<String, String> map, int times) {
		jedis.hmset(key, map);
		jedis.expire(key, times);
	}
	
	/**
	 * 存储Hash：永久存在
	 * 
	 * @param key
	 * @param map
	 */
	public void insertHash(Jedis jedis,String key, Map<String, String> map) {
		jedis.hmset(key, map);
	}
	
	/**
	 * 获取Hash
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, String> getHash(Jedis jedis,String key) {
		return jedis.hgetAll(key);
	}
	
	/**
	 * 删除redis中保存的map集合指定的key对应的对象
	 * 
	 * @param key : redis的map集合key
	 * @param hashKey : hashKey redis中map集合中对象的key
	 */
	public void hDel(Jedis jedis,String key, String hashKey) {
		if(StringUtils.isEmpty(key) || StringUtils.isEmpty(hashKey)){
			return;
		}
		jedis.hdel(key, hashKey);
	}
	
	/**
	 * 
	 * @Title: hSet
	 * @Description: 放入redis的Map中,可放入任意对象,序列化为byte[]形式保存
	 * @param jedis
	 * @param key
	 * @param hashKey
	 * @param value:void
	 * 
	 */
	public void hSet(Jedis jedis,String key, String hashKey, Object value) {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(hashKey) || ObjectUtils.isNull(value)) {
			return;
		}
		jedis.hset(key.getBytes(), hashKey.getBytes(), ObjectUtils.serialize(value));
	}
	
	/**
	 * 将Map集合放入redis的Map中,序列化为byte[]形式保存
	 * @param key  : redis的map集合key
	 * @param hashKey : hashKey redis中map集合中对象的key
	 * @param value  : map对象
	 */
	@SuppressWarnings("rawtypes")
	public <T> void hSetAll(Jedis jedis,String key, Object mapObj) {
		if (StringUtils.isEmpty(key) || ObjectUtils.isNull(mapObj)) {
			return;
		}
		if (mapObj instanceof Map) {
			Map map = (Map) mapObj;
			for (Object keySet : map.keySet()) {
				Object value = map.get(keySet);
				hSet(jedis, key, String.valueOf(keySet), value);
			}
		}
	}
	
	/**
	 * 校验redis的Map中是否存在hashKey的键 
	 * @param key : redis的map集合key
	 * @param hashKey : hashKey redis中map集合中对象的key
	 */
	public boolean hexists(Jedis jedis,String key, String hashKey) {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(hashKey)) {
			return false;
		}
		return jedis.hexists(key.getBytes(), hashKey.getBytes());
	}
	
	/**
	 * 从redis中取出Hash规则的值转换为指定的泛型对象---序列化为byte[]的数据
	 * 
	 * @param key
	 *            : redis的map集合key
	 * @param hashKey
	 *            : hashKey redis中map集合中对象的key
	 * @param clazz
	 *            : 需要转换的泛型类的class
	 * @return T
	 */
	public <T> T hGet(Jedis jedis,String key, String hashKey, Class<T> clazz) {
		return JSONUtils.parseObject(hGet(jedis, key, hashKey),clazz);
	}
	
	/**
	 * 从redisMap集合中中取出key对应所有数据 序列化为byte[]的 
	 * @param key : redis的map集合key
	 * @return
	 */
	public <T> Map<String, T> hGetAll(Jedis jedis,String key, Class<T> clazz) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}
		Map<String, T> retMap = new HashMap<>();
		Map<byte[], byte[]> redisMap = jedis.hgetAll(key.getBytes());
		for (byte[] keybyte : redisMap.keySet()) {
			String keyStr = new String(keybyte);
			Object value = ObjectUtils.unserialize(redisMap.get(keybyte));
			retMap.put(keyStr, JSONUtils.parseObject(value, clazz));
		}
		return retMap;
	}
	
	/**
	 * @Title: hGetAll
	 * @Description: TODO
	 * @param jedis
	 * @param key
	 * @return:Map<String,String>
	 */
	public Map<String,String> hGetAll(Jedis jedis,String key){
		return jedis.hgetAll(key);
	}
	
	/**
	 * 从redis中取出序列化为byte[]的保存的值
	 * 
	 * @param key : redis的map对象的键
	 * @param field : hashKey
	 * @param clazz : 需要转换的泛型类的class
	 * @return
	 */
	public Object hGet(Jedis jedis,String key, String hashKey) {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(hashKey)) {
			return null;
		}
		return ObjectUtils.unserialize(jedis.hget(key.getBytes(), hashKey.getBytes()));
	}
	
	/**
	 * 
	 * @Title: hGetMapByHashKyes 
	 * @Description: 根据hashKey列表获取指定key的map集合--
	 * --------------该集合获取的是泛型对象
	 * --------------该方法对获取的为序列化为byte[]的数据 @param key
	 * : String : redis的Map集合的主key @param hashKey : String :
	 * redis的Map集合的hashKey @return:Map<String,Object> : 返回获取到的Map集合的对象 
	 */
	public <T> Map<String, T> hGetMapByHashKyes(Jedis jedis,String key, List<String> hashKeys, Class<T> clazz) {
		if (StringUtils.isEmpty(key) || hashKeys.isEmpty()) {
			return null;
		}
		Map<String, T> retMap = new HashMap<>();
		for (String hashKey : hashKeys) {
			// 从redis中获取数据后反序列化为对象
			Object redisObj = ObjectUtils.unserialize(jedis.hget(key.getBytes(), hashKey.getBytes()));
			// 将反序列化的对象转化为泛型对象
			retMap.put(hashKey, JSONUtils.parseObject(redisObj, clazz));
		}
		return retMap;
	}
	
	/**
	 * 获取redis中的map集合--序列化为byte[]的数据
	 * @param key : redis的map对象的键
	 */
	public <T> Map<String, Object> hGetMap(Jedis jedis,String key) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}
		Map<String, Object> retMap = new HashMap<>();
		Map<byte[], byte[]> redisMap = jedis.hgetAll(key.getBytes());
		for (byte[] keybyte : redisMap.keySet()) {
			String keyStr = new String(keybyte);
			Object value = ObjectUtils.unserialize(redisMap.get(keybyte));
			retMap.put(keyStr, value);
		}
		return retMap;
	}
	
	/**
	 * 
	 * @Title: hSetObjStr 
	 * @Description:根据key和hashKey放入Obj的对象，该对象在redis中为字符串 
	 * @param key : String:redis的Map主key 
	 * @param hashKey : String : redis的Map对象的hashKey 
	 * @param obj:
	 * 保存的ObjectL类型 @return void 
	 */
	public void hSetStr(Jedis jedis,String key, String hashKey, Object obj) {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(hashKey)) {
			return;
		}
		jedis.hset(key, hashKey, JSONUtils.parseObject(obj, String.class));
	}

	/**
	 * 
	 * @Title: hGetStr 
	 * @Description:根据key和hashKey获取泛型对象--此方法要求map对应的值为字符串类型
	 * @param key : String:redis的Map主key 
	 * @param hashKey : String : redis的Map对象的hashKey 
	 * @param clazz : Class : 需要反序列化的对象class 
	 * @return:T 
	 * 
	 */
	public <T> T hGetStr(Jedis jedis,String key, String hashKey, Class<T> clazz) {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(hashKey)) {
			return null;
		}
		return JSONUtils.parseObject(jedis.hget(key, hashKey), clazz);
	}
	
	/**
	 * 
	 * @Title:hGetMapStr 
	 * @Description:获取redis中的指定map键的所有对象--此种方式需要保存在map中的值为字符串--效率高
	 * @param key : Map的主键 
	 * @return:Map<String,Object> 
	 * 
	 */
	public Map<String, Object> hGetMapStr(Jedis jedis,String key) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}
		Map<String, Object> retMap = new HashMap<>();
		retMap.putAll(jedis.hgetAll(key));
		return retMap;
	}
	/**
	 * 
	 * @Title:hGetMapStr 
	 * @Description:获取redis中的指定map键的所有对象并转换为泛型对象--此种方式需要保存在map中的值为字符串--效率高
	 * @param key : Map的主键
	 * @param clazz : 泛型Class
	 * @return:Map<String,Object> 
	 * 
	 */
	public <T> Map<String,T> hGetAllStr(Jedis jedis,String key,Class<T> clazz) {
		if (StringUtils.isEmpty(key) || clazz == null) {
			return null;
		}
		Map<String,T> retMap = new HashMap<>();
		Map<String,String> dataMap = jedis.hgetAll(key);
		for(String keySet : dataMap.keySet()){
			retMap.put(keySet, JSONUtils.parseObject(dataMap.get(keySet), clazz));
		}
		return retMap;
	}
	/**
	 * 
	 * @Title: hGetMapStrByHashKyes 
	 * @Description:根据hashKey列表获取指定key的map集合,该集合获取的是泛型对象 
	 * @param key 
	 * @param hashKey 
	 * @return:Map<String,Object> 
	 * 
	 */
	public <T> Map<String, T> hGetMapStrByHashKyes(Jedis jedis,String key, List<String> hashKeys, Class<T> clazz) {
		if (StringUtils.isEmpty(key) || hashKeys.isEmpty()) {
			return null;
		}
		Map<String, T> retMap = new HashMap<>();
		for (String hashKey : hashKeys) {
			retMap.put(hashKey, JSONObject.parseObject(jedis.hget(key, hashKey), clazz));
		}
		return retMap;
	}
	
	/**
	 * 
	 * @Title: hmset
	 * @Description: 设置hmset
	 * @param jedis
	 * @param key
	 * @param value:void
	 * 
	 */
	public void hmset(Jedis jedis,String key,Map<String,String> value){
		jedis.hmset(key, value);
	}
	
	/**
	 * 根据主key列表批量获取数据
	 * @Title : batchGetByKeys 
	 * @param jedis : jedis客户端
	 * @param redisPrimaryKeys : redis主key列表
	 * @return Map<String,Object>
	 * 
	 */
	public Map<String,Object> batchGetByKeys(Jedis jedis,List<String> redisPrimaryKeys){
		Map<String,Object> retMap = new HashMap<>();
		if(CollectionUtil.isEmpty(redisPrimaryKeys)){
			return retMap; 
		}
		for(String redisKey : redisPrimaryKeys){
			String value = jedis.get(redisKey);
			if(StringUtils.isNotEmpty(value)){
				retMap.put(redisKey, value);
			}
		}
		return retMap;
	}
}
