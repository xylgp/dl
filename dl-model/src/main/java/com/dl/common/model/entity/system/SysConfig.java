/**
  * <pre>
  * 系统缩写：system
  * 系统名称：system
  * 组件名称：系统管理
  * 文件名称：SysConfig.java
  * 作    者：刘广平
  * 创建日期：2018-10-10
  * </pre>
  */
package com.dl.common.model.entity.system;

import com.dl.common.model.base.BaseEntity;
import java.util.Date;

/**
 * <pre>
 * 实体类
 * 数据库表名称：tbl_sys_config
 * </pre>
 */
public class SysConfig extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：key
     * 数据库字段信息:sysKey VARCHAR(20)
     */
	private String sysKey;

    /**
     * 字段名称：value
     * 数据库字段信息:sysValue VARCHAR(20)
     */
	private String sysValue;

    /**
     * 字段名称：类别
     * 数据库字段信息:sysGroup VARCHAR(20)
     */
	private String sysGroup;

    /**
     * 字段名称：状态(0：禁用，1：启用)
     * 数据库字段信息:status VARCHAR(255)
     */
	private String status;

    /**
     * 字段名称：备注
     * 数据库字段信息:remark VARCHAR(30)
     */
	private String remark;

    /**
     * 字段名称：创建时间
     * 数据库字段信息:createTime DATETIME(19)
     */
	private Date createTime;

    /**
     * 字段名称：修改时间
     * 数据库字段信息:updateTime DATETIME(19)
     */
	private Date updateTime;

    public SysConfig() {
    }	

	

	public String getSysKey() {
        return this.sysKey;
    }


	public void setSysKey(String sysKey) {
        this.sysKey = sysKey;
    }

	

	public String getSysValue() {
        return this.sysValue;
    }


	public void setSysValue(String sysValue) {
        this.sysValue = sysValue;
    }

	

	public String getSysGroup() {
        return this.sysGroup;
    }


	public void setSysGroup(String sysGroup) {
        this.sysGroup = sysGroup;
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


	
	public Date getUpdateTime() {
        return this.updateTime;
    }


	public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}