/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：AuthDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-10-13
  * </pre>
  */
package com.dl.common.dao.user.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.entity.user.Auth;
import com.dl.common.dao.user.AuthDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("AuthDao")
public class AuthDaoImpl extends BaseDaoImpl<Auth> implements AuthDao {

	@Override
	public List<String> getAuthListByRoleList(List<String> roleList) {
		return sessionTemplate.selectList(getStatement("getAuthListByRoleList"),roleList);
	}
	

}