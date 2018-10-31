/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：RoleServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */
package com.dl.common.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.entity.user.Role;
import com.dl.common.service.user.RoleService;
import com.dl.common.dao.user.RoleDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	
	@Autowired
	RoleDao dao;
	
	@Override
	protected BaseDao<Role> getDao() {
		return dao;
	}

	@Override
	public List<String> getRoleListByUserId(String userId,int type) {
		return dao.getRoleListByUserId(userId,type);
	}

}