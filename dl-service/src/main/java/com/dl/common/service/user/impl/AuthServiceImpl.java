/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：AuthServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-10-13
  * </pre>
  */
package com.dl.common.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.entity.user.Auth;
import com.dl.common.service.user.AuthService;
import com.dl.common.dao.user.AuthDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("authService")
public class AuthServiceImpl extends BaseServiceImpl<Auth> implements AuthService {
	
	@Autowired
	AuthDao dao;
	
	@Override
	protected BaseDao<Auth> getDao() {
		return dao;
	}

	@Override
	public List<String> getAuthListByRoleList(List<String> roleList) {
		return dao.getAuthListByRoleList(roleList);
	}

}