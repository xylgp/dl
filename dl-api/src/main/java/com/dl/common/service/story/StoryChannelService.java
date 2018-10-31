/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryChannelService.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.service.story;

import java.util.List;

import com.dl.common.base.BaseService;
import com.dl.common.model.app.req.StoryListRequest;
import com.dl.common.model.app.req.StoryResponse;
import com.dl.common.model.entity.story.StoryChannel;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface StoryChannelService extends BaseService<StoryChannel> {
    
	/**
	 * 按故事ID删除板块对应关系 
	 * @param storyId
	 */
	public void deleteByStoryId(String storyId);
	
	
	/**
	 * 根据板块查询指定时间段，审批通过的故事列表 
	 * @param channelCode
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public List<StoryResponse> selectStoryListByCodeAndTime(String channelCode,String beginTime,String endTime);
	
	/**
	 * 根据板块查询指定条数，审批通过的故事列表
	 * @param channelCode
	 * @param limit
	 * @return
	 */
	public List<StoryResponse> selectStoryListByCodeAndLimit(String channelCode,int limit);
	
	/**
	 * 根据板块查询分页列表
	 * @param listRequest
	 * @return
	 */
	public List<StoryResponse> selectStoryListByPage(StoryListRequest listRequest);
}