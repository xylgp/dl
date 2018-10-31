/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryChannelDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.dao.story.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.app.req.StoryListRequest;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.StoryChannel;
import com.dl.common.dao.story.StoryChannelDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("StoryChannelDao")
public class StoryChannelDaoImpl extends BaseDaoImpl<StoryChannel> implements StoryChannelDao {

	@Override
	public void deleteByStoryId(String storyId) {
		sessionTemplate.delete(getStatement("deleteByStoryId"),storyId);
	}

	@Override
	public List<StoryResponse> selectStoryListByCodeAndTime(String channelCode, String beginTime, String endTime) {
		Map<String, String> params = new HashMap<>();
		params.put("channelCode", channelCode);
		params.put("beginTime", beginTime);
		params.put("endTime", endTime);
		return sessionTemplate.selectList(getStatement("selectStoryListByCodeAndTime"), params);
	}

	@Override
	public List<StoryResponse> selectStoryListByCodeAndLimit(String channelCode, int limit) {
		Map<String, String> params = new HashMap<>();
		params.put("channelCode", channelCode);
		params.put("limit", String.valueOf(limit));
		return sessionTemplate.selectList(getStatement("selectStoryListByCodeAndLimit"), params);
	}

	@Override
	public List<StoryResponse> selectStoryListByPage(StoryListRequest storyRequest) {
		return sessionTemplate.selectList(getStatement("selectStoryListByPage"), storyRequest);
	}
	

}