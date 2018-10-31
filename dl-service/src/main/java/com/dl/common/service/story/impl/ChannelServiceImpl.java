/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：ChannelServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.service.story.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.base.ResponseCodeEnum;
import com.dl.common.model.entity.story.Channel;
import com.dl.common.service.story.ChannelService;
import com.dl.common.dao.story.ChannelDao;
import com.dl.common.framework.exception.DlException;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("channelService")
public class ChannelServiceImpl extends BaseServiceImpl<Channel> implements ChannelService {
	
	@Autowired
	ChannelDao dao;
	
	@Override
	protected BaseDao<Channel> getDao() {
		return dao;
	}

	@Override
	public List<Channel> getDefaultChannelList() {
		Channel channel = new Channel();
		channel.setIsDefault(1);
		channel.setStatus(1);
		return dao.selectChannelList(channel);
	}

	@Override
	public List<Channel> getFullChannelList() {
		Channel channel = new Channel();
		channel.setStatus(1);
		return dao.selectChannelList(channel);
	}

	@Override
	public Channel getByChannelCode(String channelCode) {
		return dao.selectByChannelCode(channelCode);
	}
	
	@Override
	public void test(String usedId){
		if(StringUtils.isNotEmpty(usedId)){
			throw new DlException(ResponseCodeEnum.MYSQL_INSERT_ERROR.code);
		}
	}

}