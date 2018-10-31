/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserAttentionServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-10-18
  * </pre>
  */
package com.dl.common.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.model.entity.user.User;
import com.dl.common.model.entity.user.UserAttention;
import com.dl.common.service.user.UserAttentionService;
import com.dl.common.dao.user.UserAttentionDao;
import com.dl.common.dao.user.UserDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("userAttentionService")
public class UserAttentionServiceImpl extends BaseServiceImpl<UserAttention> implements UserAttentionService {
	
	@Autowired
	UserAttentionDao dao;
	@Autowired
	UserDao userDao;
	
	@Override
	protected BaseDao<UserAttention> getDao() {
		return dao;
	}

	@Override
	public void attention(UserRequest request) {
		//存储关注人列表
		UserAttention attention = new UserAttention();
		attention.setUserId(request.getUserId());
		attention.setAttentionId(request.getAttentionId());
		attention.setCreateTime(new Date());
		dao.insert(attention);
		//修改关注人数 +1
		userDao.addFollowCount(request.getUserId());
		//修改被关注人粉丝数 +1
		userDao.addFansCount(request.getAttentionId());
	}

	@Override
	public void cancelAttention(UserRequest request) {
		//软删除用户关注表
//		dao.cancelAttention(request.getUserId(), request.getAttentionId());
		dao.deleteAttention(request.getUserId(), request.getAttentionId());
		//修改关注人数 -1
		userDao.cutFollowCount(request.getUserId());
		//修改被关注人粉丝数 -1
		userDao.cutFansCount(request.getAttentionId());
	}

	@Override
	public List<User> attentionList(UserRequest request) {
		return dao.attentionList(request.getUserId());
	}

	@Override
	public List<User> fansList(UserRequest request) {
		return dao.fansList(request.getAttentionId());
	}

}