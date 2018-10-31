/**
  * <pre>
  * 系统缩写：system
  * 系统名称：system
  * 组件名称：系统管理
  * 文件名称：SysConfigDao.java
  * 作    者：刘广平
  * 创建日期：2018-10-9
  * </pre>
  */
package com.dl.common.dao.system;

import java.util.List;

import com.dl.common.dao.base.BaseDao;
import com.dl.common.model.entity.system.SysConfig;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface SysConfigDao extends BaseDao<SysConfig> {
    
	List<SysConfig> selectByStatus(int status);
}