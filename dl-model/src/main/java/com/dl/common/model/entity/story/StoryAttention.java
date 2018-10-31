/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryAttention.java
  * 作    者：刘广平
  * 创建日期：2018-10-31
  * </pre>
  */
package com.dl.common.model.entity.story;

import com.dl.common.model.base.BaseEntity;
import java.util.Date;

/**
 * <pre>
 * 实体类
 * 数据库表名称：tbl_story_attention
 * </pre>
 */
public class StoryAttention extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：用户id
     * 数据库字段信息:userId BIGINT(19)
     */
	private String userId;

    /**
     * 字段名称：标题
     * 数据库字段信息:title VARCHAR(50)
     */
	private String title;

    /**
     * 字段名称：被关注用户的id
     * 数据库字段信息:attentionId BIGINT(19)
     */
	private String attentionId;

    /**
     * 字段名称：故事id
     * 数据库字段信息:storyId BIGINT(19)
     */
	private String storyId;

    /**
     * 字段名称：类型（1：关注人发布故事）
     * 数据库字段信息:type INT(10)
     */
	private String type;

    /**
     * 字段名称：创建时间
     * 数据库字段信息:createTime DATETIME(19)
     */
	private Date createTime;

    /**
     * 字段名称：更新时间
     * 数据库字段信息:updateTime DATETIME(19)
     */
	private Date updateTime;

    public StoryAttention() {
    }	

	

	public String getUserId() {
        return this.userId;
    }


	public void setUserId(String userId) {
        this.userId = userId;
    }

	

	public String getTitle() {
        return this.title;
    }


	public void setTitle(String title) {
        this.title = title;
    }

	

	public String getAttentionId() {
        return this.attentionId;
    }


	public void setAttentionId(String attentionId) {
        this.attentionId = attentionId;
    }

	

	public String getStoryId() {
        return this.storyId;
    }


	public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

	

	public String getType() {
        return this.type;
    }


	public void setType(String type) {
        this.type = type;
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