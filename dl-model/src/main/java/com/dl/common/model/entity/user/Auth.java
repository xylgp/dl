/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：Auth.java
  * 作    者：刘广平
  * 创建日期：2018-10-13
  * </pre>
  */
package com.dl.common.model.entity.user;

import com.dl.common.model.base.BaseEntity;

/**
 * <pre>
 * 实体类
 * 数据库表名称：tbl_auth
 * </pre>
 */
public class Auth extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：编码
     * 数据库字段信息:code VARCHAR(50)
     */
	private String code;

    /**
     * 字段名称：名称
     * 数据库字段信息:name VARCHAR(20)
     */
	private String name;

    /**
     * 字段名称：模块id
     * 数据库字段信息:module_id INT(10)
     */
	private String moduleid;

    public Auth() {
    }	

	

	public String getCode() {
        return this.code;
    }


	public void setCode(String code) {
        this.code = code;
    }

	

	public String getName() {
        return this.name;
    }


	public void setName(String name) {
        this.name = name;
    }

	

	public String getModuleid() {
        return this.moduleid;
    }


	public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

}