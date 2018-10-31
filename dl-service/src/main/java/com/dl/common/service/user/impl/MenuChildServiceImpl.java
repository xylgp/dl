/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：MenuChildServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */
package com.dl.common.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.entity.user.MenuChild;
import com.dl.common.service.user.MenuChildService;
import com.dl.common.dao.user.MenuChildDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("menuChildService")
public class MenuChildServiceImpl extends BaseServiceImpl<MenuChild> implements MenuChildService {
	
	@Autowired
	MenuChildDao dao;
	
	@Override
	protected BaseDao<MenuChild> getDao() {
		return dao;
	}

}