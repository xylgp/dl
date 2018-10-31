/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryChannelServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.service.story.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.app.req.StoryListRequest;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.StoryChannel;
import com.dl.common.service.story.StoryChannelService;
import com.dl.common.dao.story.StoryChannelDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("storyChannelService")
public class StoryChannelServiceImpl extends BaseServiceImpl<StoryChannel> implements StoryChannelService {
	
	@Autowired
	StoryChannelDao dao;
	
	@Override
	protected BaseDao<StoryChannel> getDao() {
		return dao;
	}

	@Override
	public void deleteByStoryId(String storyId) {
		dao.deleteByStoryId(storyId);
	}

	@Override
	public List<StoryResponse> selectStoryListByCodeAndTime(String channelCode, String beginTime, String endTime) {
		return dao.selectStoryListByCodeAndTime(channelCode, beginTime, endTime);
	}

	@Override
	public List<StoryResponse> selectStoryListByCodeAndLimit(String channelCode, int limit) {
		return dao.selectStoryListByCodeAndLimit(channelCode, limit);
	}

	@Override
	public List<StoryResponse> selectStoryListByPage(StoryListRequest listRequest) {
		return dao.selectStoryListByPage(listRequest);
	}

}