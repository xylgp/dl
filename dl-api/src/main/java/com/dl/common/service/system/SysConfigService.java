/**
  * <pre>
  * 系统缩写：system
  * 系统名称：system
  * 组件名称：系统管理
  * 文件名称：SysConfigService.java
  * 作    者：刘广平
  * 创建日期：2018-10-9
  * </pre>
  */
package com.dl.common.service.system;

import java.util.List;

import com.dl.common.base.BaseService;
import com.dl.common.model.entity.system.SysConfig;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface SysConfigService extends BaseService<SysConfig> {
    
	/**
	 * 根据状态查询配置列表（不分页）
	 * @param status
	 * @return
	 */
	public List<SysConfig> selectByStatus(int status);
}