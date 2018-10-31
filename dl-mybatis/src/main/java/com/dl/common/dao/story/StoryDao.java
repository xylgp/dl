/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryDao.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.dao.story;

import java.util.List;

import com.dl.common.dao.base.BaseDao;
import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.Story;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface StoryDao extends BaseDao<Story> {
    //根据状态查询故事列表
	List<StoryResponse> checkList(StoryRequest storyReq);
	//查询故事静态内容
	Story getStoryStaticContent(String id);
	//查询故事动态内容
	StoryResponse getStoryDynamicContent(String id);
	//根据用户id和订单状态
	List<StoryResponse> selectStoryListByUserAndStatus(String userId,Integer status);
}