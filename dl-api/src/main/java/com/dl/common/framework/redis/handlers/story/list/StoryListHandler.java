package com.dl.common.framework.redis.handlers.story.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.druid.support.json.JSONUtils;
import com.dl.common.framework.redis.handlers.story.RedisHandlerStoryAbstract;
import com.dl.common.framework.redis.redisKey.RedisStoryKey;
import com.dl.common.model.entity.story.Story;

public class StoryListHandler extends RedisHandlerStoryAbstract{

	@Override
	@SuppressWarnings("unchecked")
	protected void insertObjToRedis(Object obj) {
		List<Story> storyList = (List<Story>) obj;
		if(storyList == null || storyList.size() == 0) return;
		switch (redisCache.key()) {
		case RedisStoryKey.STORY_LIST:
			insertStoryListToRedis(storyList);
			break;
		default:
			break;
		}
	}

	/**
	 * 添加故事到redis缓存
	 * @param storyList
	 */
	protected void insertStoryListToRedis(List<Story> storyList) {
		Map<String,Double> scoreMembers = new HashMap<>();
		for(Story story : storyList){
			scoreMembers.put(JSONUtils.toJSONString(story), Double.valueOf(story.getId()));
		}
	}
}
