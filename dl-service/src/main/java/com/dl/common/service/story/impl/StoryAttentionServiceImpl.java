/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryAttentionServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-10-31
  * </pre>
  */
package com.dl.common.service.story.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.model.entity.story.StoryAttention;
import com.dl.common.service.story.StoryAttentionService;
import com.dl.common.dao.story.StoryAttentionDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("storyAttentionService")
public class StoryAttentionServiceImpl extends BaseServiceImpl<StoryAttention> implements StoryAttentionService {
	
	@Autowired
	StoryAttentionDao dao;
	
	@Override
	protected BaseDao<StoryAttention> getDao() {
		return dao;
	}

	@Override
	public List<StoryAttention> selectListByUserId(StoryRequest storyRequest) {
		if(storyRequest.getPageSize() == 0) storyRequest.setPageSize(10);
		storyRequest.setIndex(storyRequest.getNowPage() * storyRequest.getPageSize());
		return dao.selectListByUserId(storyRequest);
	}

	@Override
	public void batchInsert(List<StoryAttention> list) {
		dao.batchInsert(list);	
	}

}