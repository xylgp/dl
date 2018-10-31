package com.dl.common.framework.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

public class RedisService {
	
	private JedisPool jedisPool;
	
	public RedisService() {}
	public RedisService(JedisPool jedisPool){
		this.jedisPool = jedisPool;
	}
	
	public JedisPool getJedisPool(){
		return this.jedisPool;
	}
	
	public Jedis getJedis() throws JedisException{
		Jedis jedis = null;
		try {
			jedis = this.jedisPool.getResource();
			//TODO 完善日志
//			LoggerUtil.debug(StringUtils.join(new String[] { "return jedis:active num=" + this.jedisPool.getNumActive(),
//			",idle num=" + this.jedisPool.getNumIdle(), ",wait num=" + this.jedisPool.getNumWaiters() }));
			return jedis;
		} catch (JedisException e) {
			//释放redis
			releaseJedis(jedis);
			//TODO 完善异常，抛出异常，获取redis失败
			return null;
		}
	}
	
	public void releaseJedis(Jedis jedis){
		if(jedis != null){
			jedis.close();
			//TODO 完善日志
//			LoggerUtil.debug(StringUtils.join(new String[] { "return jedis:active num=" + this.jedisPool.getNumActive(),
//					",idle num=" + this.jedisPool.getNumIdle(), ",wait num=" + this.jedisPool.getNumWaiters() }));
		}
	}
}
