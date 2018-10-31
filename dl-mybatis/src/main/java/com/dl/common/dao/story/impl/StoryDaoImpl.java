/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryDaoImpl.java
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
import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.Story;
import com.dl.common.dao.story.StoryDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("StoryDao")
public class StoryDaoImpl extends BaseDaoImpl<Story> implements StoryDao {

	@Override
	public List<StoryResponse> checkList(StoryRequest storyReq) {
		return sessionTemplate.selectList(getStatement("checkList"), storyReq);
	}

	@Override
	public Story getStoryStaticContent(String id) {
		return sessionTemplate.selectOne(getStatement("getStoryStaticContent"), id);
	}

	@Override
	public StoryResponse getStoryDynamicContent(String id) {
		return sessionTemplate.selectOne(getStatement("getStoryDynamicContent"), id);
	}

	@Override
	public List<StoryResponse> selectStoryListByUserAndStatus(String userId, Integer status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("status", status);
		return sessionTemplate.selectList("selectStoryListByUserAndStatus", map);
	}

	

}