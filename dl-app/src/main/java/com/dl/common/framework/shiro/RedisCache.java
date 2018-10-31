package com.dl.common.framework.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import com.alibaba.fastjson.JSONObject;
import com.dl.common.framework.redis.RedisService;
import com.dl.common.framework.shiro.util.ByteSourceUtils;
import redis.clients.jedis.Jedis;

@SuppressWarnings({"unchecked","rawtypes"})
public class RedisCache<K,V> implements Cache<K, V>{
	
	private RedisService redisSrevice;
	
	public RedisCache(RedisService redisSrevice) {
		this.redisSrevice = redisSrevice;
	}
	
	private String keyPrefix = "shiro_redis_session:";


	@Override
    public Object get(Object key) throws CacheException {
		Jedis jedis = getJedis();
        String value = jedis.get(JSONObject.toJSONString(key));
        if(value == null){
            return null;
        }
        releaseJedis(jedis);
        return JSONObject.parseObject(value, SimpleAuthorizationInfo.class);
    }

    /**
     * 将shiro的缓存保存到redis中
     */
    @Override
    public Object put(Object key, Object value) throws CacheException {

        Jedis jedis = getJedis();
        jedis.set(JSONObject.toJSONString(key), JSONObject.toJSONString(value));
        releaseJedis(jedis);
        return value;

    }

    @Override
    public Object remove(Object key) throws CacheException {
        Jedis jedis = getJedis();
        String value = jedis.get(JSONObject.toJSONString(key));
        jedis.del(JSONObject.toJSONString(key));
        releaseJedis(jedis);
        return value;
    }

    /**
     * 清空所有缓存
     */
    @Override
    public void clear() throws CacheException {
    	Jedis jedis = getJedis();
        jedis.flushDB();
        releaseJedis(jedis);
    }

    /**
     * 缓存的个数
     */
    @Override
    public int size() {
    	Jedis jedis = getJedis();
        Long size = jedis.dbSize();
        releaseJedis(jedis);
        return size.intValue();
    }

    /**
     * 获取所有的key
     */
    @Override
    public Set keys() {
    	Jedis jedis = getJedis();
        Set<String> keys = jedis.keys(new String("*"));
        Set<Object> set = new HashSet<Object>();
        for (String bs : keys) {
            set.add(bs);
        }
        releaseJedis(jedis);
        return set;
    }


    /**
     * 获取所有的value
     */
	@Override
    public Collection values() {
		Jedis jedis = getJedis();
        Set keys = this.keys();

        List<String> values = new ArrayList<String>();
        for (Object key : keys) {
            String value = jedis.get(JSONObject.toJSONString(key));
            values.add(value);
        }
        releaseJedis(jedis);
        return values;
    }
	
	private Jedis getJedis(){
		Jedis jedis = redisSrevice.getJedis();
		jedis.select(2);
		return jedis;
	}
	
	private void releaseJedis(Jedis jedis){
		redisSrevice.releaseJedis(jedis);
		
	}
	
	/**
     * 获得byte[]型的key
     * @param key
     * @return
     */
    private byte[] getByteKey(Object key){
        if(key instanceof String){
            String preKey = this.keyPrefix + key;
            return preKey.getBytes();
        }else{
            return ByteSourceUtils.serialize((Serializable) key);
        }
    }
	
}
