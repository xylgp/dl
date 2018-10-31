package com.dl.common.framework.redis.template;

import java.util.List;
import org.springframework.stereotype.Component;
import com.dl.common.framework.redis.utils.RedisKeyUtil;
import com.dl.common.model.entity.system.SysConfig;
import redis.clients.jedis.Jedis;

@Component
public class RedisConfigTemplate {
	
	/**
	 * 批量存储数据库的配置
	 * @param jedis
	 * @param configList
	 */
	public void storeConfigList(Jedis jedis,List<SysConfig> configList){
		for(SysConfig sysConfig : configList){
			jedis.set(RedisKeyUtil.createRedisKeyConfig(sysConfig.getSysGroup(),sysConfig.getSysKey()), sysConfig.getSysValue());
		}
	}
	
	/**
	 * 获取配置值
	 * @param jedis
	 * @param keys
	 * @return
	 */
	public String getSysConfig(Jedis jedis,String... keys){
		return jedis.get(RedisKeyUtil.createRedisKeyConfig(keys));
	}
}
