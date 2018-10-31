/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserRole.java
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
 * 数据库表名称：tbl_user_role
 * </pre>
 */
public class UserRole extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：用户id
     * 数据库字段信息:userId BIGINT(19)
     */
	private String userId;

    /**
     * 字段名称：角色id
     * 数据库字段信息:roleId BIGINT(19)
     */
	private String roleId;

    /**
     * 字段名称：状态（0：无效，1：有效）
     * 数据库字段信息:status INT(10)
     */
	private String status;

    public UserRole() {
    }	

	

	public String getUserId() {
        return this.userId;
    }


	public void setUserId(String userId) {
        this.userId = userId;
    }

	

	public String getRoleId() {
        return this.roleId;
    }


	public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

	

	public String getStatus() {
        return this.status;
    }


	public void setStatus(String status) {
        this.status = status;
    }

}