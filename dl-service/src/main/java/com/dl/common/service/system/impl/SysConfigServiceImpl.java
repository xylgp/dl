/**
  * <pre>
  * 系统缩写：system
  * 系统名称：system
  * 组件名称：系统管理
  * 文件名称：SysConfigServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-10-9
  * </pre>
  */
package com.dl.common.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.entity.system.SysConfig;
import com.dl.common.service.system.SysConfigService;
import com.dl.common.dao.system.SysConfigDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("sysConfigService")
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfig> implements SysConfigService {
	
	@Autowired
	SysConfigDao dao;
	
	@Override
	protected BaseDao<SysConfig> getDao() {
		return dao;
	}

	@Override
	public List<SysConfig> selectByStatus(int status) {
		return dao.selectByStatus(status);
	}

}