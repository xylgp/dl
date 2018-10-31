/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryOutlineDao.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.dao.story;

import java.util.List;

import com.dl.common.dao.base.BaseDao;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.StoryOutline;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface StoryOutlineDao extends BaseDao<StoryOutline> {
    
	List<StoryResponse> storyOutline(String rootId);
}