/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：Role.java
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
import java.util.Date;

/**
 * <pre>
 * 实体类
 * 数据库表名称：tbl_role
 * </pre>
 */
public class Role extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：角色代码
     * 数据库字段信息:code VARCHAR(20)
     */
	private String code;

    /**
     * 字段名称：角色名
     * 数据库字段信息:name VARCHAR(50)
     */
	private String name;

    /**
     * 字段名称：状态（0：未启用，1：启用）
     * 数据库字段信息:status INT(10)
     */
	private String status;

    /**
     * 字段名称：备注
     * 数据库字段信息:remark VARCHAR(200)
     */
	private String remark;

    /**
     * 字段名称：创建时间
     * 数据库字段信息:createTime DATETIME(19)
     */
	private Date createTime;

    public Role() {
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

	

	public String getStatus() {
        return this.status;
    }


	public void setStatus(String status) {
        this.status = status;
    }

	

	public String getRemark() {
        return this.remark;
    }


	public void setRemark(String remark) {
        this.remark = remark;
    }

	
	public Date getCreateTime() {
        return this.createTime;
    }


	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}