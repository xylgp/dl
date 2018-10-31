/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：MenuAuth.java
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
 * 数据库表名称：tbl_menu_auth
 * </pre>
 */
public class MenuAuth extends BaseEntity{

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
     * 字段名称：菜单id
     * 数据库字段信息:menu_id INT(10)
     */
	private String menuid;

    public MenuAuth() {
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

	

	public String getMenuid() {
        return this.menuid;
    }


	public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

}