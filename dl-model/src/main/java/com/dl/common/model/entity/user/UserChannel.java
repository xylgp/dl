/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserChannel.java
  * 作    者：刘广平
  * 创建日期：2018-8-24
  * </pre>
  */
package com.dl.common.model.entity.user;

import com.dl.common.model.base.BaseEntity;
import java.util.Date;

/**
 * <pre>
 * 实体类
 * 数据库表名称：tbl_user_channel
 * </pre>
 */
public class UserChannel extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：用户ID
     * 数据库字段信息:userId BIGINT(19)
     */
	private String userId;

    /**
     * 字段名称：板块编码
     * 数据库字段信息:channelCode INT(10)
     */
	private String channelCode;

    /**
     * 字段名称：排序
     * 数据库字段信息:sort INT(10)
     */
	private String sort;

    /**
     * 字段名称：状态（0：禁用，1：启用）
     * 数据库字段信息:status INT(10)
     */
	private String status;

    /**
     * 字段名称：创建时间
     * 数据库字段信息:createTime DATETIME(19)
     */
	private Date createTime;

    public UserChannel() {
    }	

	

	public String getUserId() {
        return this.userId;
    }


	public void setUserId(String userId) {
        this.userId = userId;
    }

	

	public String getChannelCode() {
        return this.channelCode;
    }


	public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

	

	public String getSort() {
        return this.sort;
    }


	public void setSort(String sort) {
        this.sort = sort;
    }

	

	public String getStatus() {
        return this.status;
    }


	public void setStatus(String status) {
        this.status = status;
    }

	
	public Date getCreateTime() {
        return this.createTime;
    }


	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}