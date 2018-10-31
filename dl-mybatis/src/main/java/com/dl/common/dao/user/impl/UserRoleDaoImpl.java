/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserRoleDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */


package com.dl.common.dao.user.impl;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.entity.user.UserRole;
import com.dl.common.dao.user.UserRoleDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("UserRoleDao")
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {
	

}