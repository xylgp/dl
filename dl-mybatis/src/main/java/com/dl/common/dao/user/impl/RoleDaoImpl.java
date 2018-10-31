/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：RoleDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */


package com.dl.common.dao.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.entity.user.Role;
import com.dl.common.dao.user.RoleDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("RoleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public List<String> getRoleListByUserId(String userId,int type) {
		Map<String, Object> params= new HashMap<>();
		params.put("userId", userId);
		params.put("type", type);
		return sessionTemplate.selectList(getStatement("getRoleListByUserId"), params);
	}
	

}