/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：RoleAuth.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */

/**
  * <pre>
  * 修改记录：01  
  * 修改日期：2018-8-19
  * 修 改 人：刘广平
  * 修改内容：新建文件
  * </pre>
  */

package com.dl.common.model.entity.user;

import com.dl.common.model.base.BaseEntity;

/**
 * <pre>
 * 实体类
 * 数据库表名称：tbl_role_auth
 * </pre>
 */
public class RoleAuth extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：角色id
     * 数据库字段信息:roleId INT(10)
     */
	private String roleId;

    /**
     * 字段名称：权限id
     * 数据库字段信息:authId INT(10)
     */
	private String authId;

    public RoleAuth() {
    }	

	

	public String getRoleId() {
        return this.roleId;
    }


	public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

	

	public String getAuthId() {
        return this.authId;
    }


	public void setAuthId(String authId) {
        this.authId = authId;
    }

}