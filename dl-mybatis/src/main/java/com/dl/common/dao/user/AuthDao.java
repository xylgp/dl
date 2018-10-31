/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：AuthDao.java
  * 作    者：刘广平
  * 创建日期：2018-10-13
  * </pre>
  */
package com.dl.common.dao.user;

import java.util.List;

import com.dl.common.dao.base.BaseDao;
import com.dl.common.model.entity.user.Auth;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface AuthDao extends BaseDao<Auth> {
    
	List<String> getAuthListByRoleList(List<String> roleList);
}