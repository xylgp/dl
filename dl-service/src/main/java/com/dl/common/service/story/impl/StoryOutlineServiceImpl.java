/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryOutlineServiceImpl.java
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
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.StoryOutline;
import com.dl.common.service.story.StoryOutlineService;
import com.dl.common.dao.story.StoryOutlineDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("storyOutlineService")
public class StoryOutlineServiceImpl extends BaseServiceImpl<StoryOutline> implements StoryOutlineService {
	
	@Autowired
	StoryOutlineDao dao;
	
	@Override
	protected BaseDao<StoryOutline> getDao() {
		return dao;
	}

	@Override
	public List<StoryResponse> storyOutline(String rootId) {
		return dao.storyOutline(rootId);
	}

}