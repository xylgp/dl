/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */
package com.dl.common.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.model.entity.user.User;
import com.dl.common.service.user.UserService;
import com.dl.common.dao.user.UserDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Autowired
	UserDao dao;
	
	@Override
	protected BaseDao<User> getDao() {
		return dao;
	}

	@Override
	public User selectByUserName(String userName) {
		return dao.selectByUserName(userName);
	}
	
	@Override
	public User selectByMobileNo(String mobileNo) {
		return dao.selectByMobileNo(mobileNo);
	}

	@Override
	public User selectByWx(String wxAccount) {
		return dao.selectByWx(wxAccount);
	}

	@Override
	public User selectByQq(String qqAccount) {
		return dao.selectByQq(qqAccount);
	}

	@Override
	public User selectByWb(String wbAccount) {
		return dao.selectByWb(wbAccount);
	}

	@Override
	public void updateUserInfo(UserRequest userRequest) {
		User user = new User();
		user.setId(userRequest.getId());
		user.setNickName(userRequest.getNickName());
		user.setImgUrl(userRequest.getImgUrl());
		user.setBirth(userRequest.getBirth());
		user.setSex(userRequest.getSex());
		user.setRemark(userRequest.getRemark());
		user.setAddress(userRequest.getAddress());
		dao.update(user);
	}

	@Override
	public void addStoryCount(String userId) {
		dao.addStoryCount(userId);
	}

	@Override
	public void cutStoryCount(String userId) {
		dao.cutStoryCount(userId);
	}

}