/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：MenuGroupServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */
package com.dl.common.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.entity.user.MenuGroup;
import com.dl.common.service.user.MenuGroupService;
import com.dl.common.dao.user.MenuGroupDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("menuGroupService")
public class MenuGroupServiceImpl extends BaseServiceImpl<MenuGroup> implements MenuGroupService {
	
	@Autowired
	MenuGroupDao dao;
	
	@Override
	protected BaseDao<MenuGroup> getDao() {
		return dao;
	}

}