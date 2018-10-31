/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryOutlineDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.dao.story.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.StoryOutline;
import com.dl.common.dao.story.StoryOutlineDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("StoryOutlineDao")
public class StoryOutlineDaoImpl extends BaseDaoImpl<StoryOutline> implements StoryOutlineDao {

	@Override
	public List<StoryResponse> storyOutline(String rootId) {
		return sessionTemplate.selectList(getStatement("selectStoryOutline"), rootId);
	}
	

}