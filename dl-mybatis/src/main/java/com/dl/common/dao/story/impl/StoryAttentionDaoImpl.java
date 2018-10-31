/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryAttentionDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-10-31
  * </pre>
  */
package com.dl.common.dao.story.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.model.entity.story.StoryAttention;
import com.dl.common.dao.story.StoryAttentionDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("StoryAttentionDao")
public class StoryAttentionDaoImpl extends BaseDaoImpl<StoryAttention> implements StoryAttentionDao {

	@Override
	public void batchInsert(List<StoryAttention> list) {
		sessionTemplate.insert(getStatement("batchInsert"), list);
	}

	@Override
	public List<StoryAttention> selectListByUserId(StoryRequest storyRequest) {
		return sessionTemplate.selectList(getStatement("selectListByUserId"), storyRequest);
	}
	

}