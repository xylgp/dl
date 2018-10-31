/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：ChannelDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.dao.story.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.entity.story.Channel;
import com.dl.common.dao.story.ChannelDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("ChannelDao")
public class ChannelDaoImpl extends BaseDaoImpl<Channel> implements ChannelDao {

	@Override
	public List<Channel> selectList(Channel channel) {
		return sessionTemplate.selectList(getStatement("selectList"), channel);
	}
	
	@Override
	public List<Channel> selectChannelList(Channel channel) {
		return sessionTemplate.selectList(getStatement("selectChannelList"), channel);
	}

	@Override
	public Channel selectByChannelCode(String channelCode) {
		return sessionTemplate.selectOne(getStatement("selectByChannelCode"), channelCode);
	}

	

}