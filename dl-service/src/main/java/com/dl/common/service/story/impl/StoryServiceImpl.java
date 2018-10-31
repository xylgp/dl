/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryServiceImpl.java
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
import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.Story;
import com.dl.common.service.story.StoryService;
import com.dl.common.dao.story.StoryDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("storyService")
public class StoryServiceImpl extends BaseServiceImpl<Story> implements StoryService {
	
	@Autowired
	StoryDao dao;
	
	@Override
	protected BaseDao<Story> getDao() {
		return dao;
	}

	@Override
	public List<StoryResponse> checkList(StoryRequest storyReq) {
		return dao.checkList(storyReq);
	}

	@Override
	public Story getStoryStaticContent(String id) {
		return dao.getStoryStaticContent(id);
	}

	@Override
	public StoryResponse getStoryDynamicContent(String id) {
		return dao.getStoryDynamicContent(id);
	}
	
	@Override
	public List<StoryResponse> selectStoryListByUserAndStatus(String userId, Integer status) {
		return dao.selectStoryListByUserAndStatus(userId, status);
	}
}