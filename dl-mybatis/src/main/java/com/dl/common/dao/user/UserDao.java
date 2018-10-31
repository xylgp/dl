/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserDao.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */


package com.dl.common.dao.user;

import com.dl.common.dao.base.BaseDao;
import com.dl.common.model.entity.user.User;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface UserDao extends BaseDao<User> {
	
	User selectByUserName(String userName);
	
	User selectByMobileNo(String mobileNo);
	
	User selectByWx(String wxAccount);
	
	User selectByQq(String qqAccount);
	
	User selectByWb(String wbAccount);
	
	void addFollowCount(String userId);
	
	void cutFollowCount(String userId);
	
	void addFansCount(String userId);
	
	void cutFansCount(String userId);
	
	void addStoryCount(String userId);
	
	void cutStoryCount(String userId);
}