/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserAttention.java
  * 作    者：刘广平
  * 创建日期：2018-10-18
  * </pre>
  */
package com.dl.common.model.entity.user;

import com.dl.common.model.base.BaseEntity;
import java.util.Date;

/**
 * <pre>
 * 实体类
 * 数据库表名称：tbl_user_attention
 * </pre>
 */
public class UserAttention extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：用户id
     * 数据库字段信息:userId BIGINT(19)
     */
	private String userId;

    /**
     * 字段名称：被关注人id
     * 数据库字段信息:attentionId BIGINT(19)
     */
	private String attentionId;

    /**
     * 字段名称：类型（0：关注人）
     * 数据库字段信息:type INT(10)
     */
	private String type;

    /**
     * 字段名称：状态（0：关注，1：取消关注）
     * 数据库字段信息:status INT(10)
     */
	private String status;

    /**
     * 字段名称：关注时间
     * 数据库字段信息:createTime DATETIME(19)
     */
	private Date createTime;

    /**
     * 字段名称：更新时间
     * 数据库字段信息:updateTime DATETIME(19)
     */
	private Date updateTime;

    public UserAttention() {
    }	

	

	public String getUserId() {
        return this.userId;
    }


	public void setUserId(String userId) {
        this.userId = userId;
    }

	

	public String getAttentionId() {
        return this.attentionId;
    }


	public void setAttentionId(String attentionId) {
        this.attentionId = attentionId;
    }

	

	public String getType() {
        return this.type;
    }


	public void setType(String type) {
        this.type = type;
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


	
	public Date getUpdateTime() {
        return this.updateTime;
    }


	public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}