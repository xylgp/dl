/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */


package com.dl.common.dao.user.impl;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.entity.user.User;
import com.dl.common.dao.user.UserDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("UserDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User selectByUserName(String userName) {
		return sessionTemplate.selectOne(getStatement("selectByUserName"), userName);
	}

	@Override
	public User selectByMobileNo(String mobileNo) {
		return sessionTemplate.selectOne(getStatement("selectByMobileNo"), mobileNo);
	}
	
	@Override
	public User selectByWx(String wxAccount) {
		return sessionTemplate.selectOne(getStatement("selectByWx"), wxAccount);
	}

	@Override
	public User selectByQq(String qqAccount) {
		return sessionTemplate.selectOne(getStatement("selectByQq"), qqAccount);
	}

	@Override
	public User selectByWb(String wbAccount) {
		return sessionTemplate.selectOne(getStatement("selectByWb"), wbAccount);
	}

	@Override
	public void addFollowCount(String userId) {
		sessionTemplate.selectOne(getStatement("addFollowCount"), userId);
	}

	@Override
	public void cutFollowCount(String userId) {
		sessionTemplate.selectOne(getStatement("cutFollowCount"), userId);
	}

	@Override
	public void addFansCount(String userId) {
		sessionTemplate.selectOne(getStatement("addFansCount"), userId);
	}

	@Override
	public void cutFansCount(String userId) {
		sessionTemplate.selectOne(getStatement("cutFansCount"), userId);
	}
	
	@Override
	public void addStoryCount(String userId) {
		sessionTemplate.selectOne(getStatement("addStoryCount"), userId);
	}

	@Override
	public void cutStoryCount(String userId) {
		sessionTemplate.selectOne(getStatement("cutStoryCount"), userId);
	}

}