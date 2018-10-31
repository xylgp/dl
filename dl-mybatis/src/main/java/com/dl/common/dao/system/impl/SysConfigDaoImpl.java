/**
  * <pre>
  * 系统缩写：system
  * 系统名称：system
  * 组件名称：系统管理
  * 文件名称：SysConfigDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-10-9
  * </pre>
  */
package com.dl.common.dao.system.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.entity.system.SysConfig;
import com.dl.common.dao.system.SysConfigDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("SysConfigDao")
public class SysConfigDaoImpl extends BaseDaoImpl<SysConfig> implements SysConfigDao {

	@Override
	public List<SysConfig> selectByStatus(int status) {
		return sessionTemplate.selectList(getStatement("selectByStatus"), status);
	}
	

}