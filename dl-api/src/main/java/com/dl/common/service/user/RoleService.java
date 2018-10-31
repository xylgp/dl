/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：RoleService.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */
package com.dl.common.service.user;

import java.util.List;

import com.dl.common.base.BaseService;
import com.dl.common.model.entity.user.Role;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface RoleService extends BaseService<Role> {
    
	/**
	 * 根据用户id获取所有的角色
	 * @param userId
	 * @return
	 */
	public List<String> getRoleListByUserId(String userId,int type);
}