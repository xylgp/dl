/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：RoleAuthServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */
package com.dl.common.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.entity.user.RoleAuth;
import com.dl.common.service.user.RoleAuthService;
import com.dl.common.dao.user.RoleAuthDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("roleAuthService")
public class RoleAuthServiceImpl extends BaseServiceImpl<RoleAuth> implements RoleAuthService {
	
	@Autowired
	RoleAuthDao dao;
	
	@Override
	protected BaseDao<RoleAuth> getDao() {
		return dao;
	}

}