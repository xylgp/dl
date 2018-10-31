/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：MenuGroup.java
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
 * 数据库表名称：tbl_menu_group
 * </pre>
 */
public class MenuGroup extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：模块组名
     * 数据库字段信息:name VARCHAR(20)
     */
	private String name;

    /**
     * 字段名称：备注
     * 数据库字段信息:remark VARCHAR(200)
     */
	private String remark;

    /**
     * 字段名称：排序
     * 数据库字段信息:sort_no INT(10)
     */
	private String sortno;

    public MenuGroup() {
    }	

	

	public String getName() {
        return this.name;
    }


	public void setName(String name) {
        this.name = name;
    }

	

	public String getRemark() {
        return this.remark;
    }


	public void setRemark(String remark) {
        this.remark = remark;
    }

	

	public String getSortno() {
        return this.sortno;
    }


	public void setSortno(String sortno) {
        this.sortno = sortno;
    }

}