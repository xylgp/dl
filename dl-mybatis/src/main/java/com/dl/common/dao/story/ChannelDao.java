/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：ChannelDao.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.dao.story;

import java.util.List;

import com.dl.common.dao.base.BaseDao;
import com.dl.common.model.entity.story.Channel;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface ChannelDao extends BaseDao<Channel> {
	
	/**
	 * 查询板块列表（包含全部的板块信息）
	 * @param channel
	 * @return
	 */
	List<Channel> selectList(Channel channel);
	
	/**
	 * 查询板块消息（只有板块编码和板块名）
	 * @param channel
	 * @return
	 */
	List<Channel> selectChannelList(Channel channel);
	
	/**
	 * 根据板块编码获取板块信息
	 * @param channelCode
	 * @return
	 */
	public Channel selectByChannelCode(String channelCode);
}