/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryAttentionDao.java
  * 作    者：刘广平
  * 创建日期：2018-10-31
  * </pre>
  */
package com.dl.common.dao.story;

import java.util.List;

import com.dl.common.dao.base.BaseDao;
import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.model.entity.story.StoryAttention;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface StoryAttentionDao extends BaseDao<StoryAttention> {
    
	public void batchInsert(List<StoryAttention> list);
	
	public List<StoryAttention> selectListByUserId(StoryRequest storyRequest);
}