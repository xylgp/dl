/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserChannelServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-24
  * </pre>
  */
package com.dl.common.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.app.req.ChannelResponse;
import com.dl.common.model.entity.user.UserChannel;
import com.dl.common.service.user.UserChannelService;
import com.dl.common.dao.user.UserChannelDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("userChannelService")
public class UserChannelServiceImpl extends BaseServiceImpl<UserChannel> implements UserChannelService {
	
	@Autowired
	UserChannelDao dao;
	
	@Override
	protected BaseDao<UserChannel> getDao() {
		return dao;
	}

	@Override
	public void batchDeleteByUserId(String userId) {
		dao.batchDeleteByUserId(userId);
	}

	@Override
	public List<ChannelResponse> getUserChannelList(String userId) {
		return dao.getUserChannelList(userId);
	}

}