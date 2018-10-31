/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryService.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.service.story;

import java.util.List;

import com.dl.common.base.BaseService;
import com.dl.common.model.app.req.StoryRequest;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.Story;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface StoryService extends BaseService<Story> {
	
	/**
	 * 根据状态查询故事列表
	 * @return
	 */
	List<StoryResponse> checkList(StoryRequest storyReq);
	
	/**
	 * 查询故事静态信息
	 * @param id
	 * @return
	 */
	Story getStoryStaticContent(String id);
	
	/**
	 * 查询故事动态信息
	 * @param id
	 * @return
	 */
	StoryResponse getStoryDynamicContent(String id);
	
	/**
	 * 根据用户id查询待审核、审核失败、审核成功的故事列表
	 * @param userId
	 * @param status
	 * @return
	 */
	List<StoryResponse> selectStoryListByUserAndStatus(String userId,Integer status);
}