package com.dl.common.framework.redis.handlers.story;

import com.dl.common.framework.redis.handlers.RedisHandlerAbstarct;
import com.dl.common.framework.redis.utils.RedisKeyUtil;
import com.dl.common.framework.redis.vo.story.QueryStoryBaseVo;

public abstract class RedisHandlerStoryAbstract extends RedisHandlerAbstarct{
	
	protected QueryStoryBaseVo baseVo;
	
	@Override
	protected void initRedisPrimaryKey() {
		redisPrimaryKey = RedisKeyUtil.createRedisKeyStory(redisCache.key(),baseVo.getChannelCode());
	}
}
