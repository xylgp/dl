/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryChannel.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.model.entity.story;

import com.dl.common.model.base.BaseEntity;
import java.util.Date;

/**
 * <pre>
 * 实体类
 * 数据库表名称：tbl_story_channel
 * </pre>
 */
public class StoryChannel extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：故事id
     * 数据库字段信息:storyId BIGINT(19)
     */
	private String storyId;

    /**
     * 字段名称：板块编码
     * 数据库字段信息:channelCode INT(10)
     */
	private String channelCode;

    /**
     * 字段名称：状态（0：禁用，1：启用）
     * 数据库字段信息:status INT(10)
     */
	private String status;

    /**
     * 字段名称：排序
     * 数据库字段信息:sort INT(10)
     */
	private String sort;

    /**
     * 字段名称：创建时间
     * 数据库字段信息:createTime DATETIME(19)
     */
	private Date createTime;

    public StoryChannel() {
    }	

	

	public String getStoryId() {
        return this.storyId;
    }


	public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

	

	public String getChannelCode() {
        return this.channelCode;
    }


	public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

	

	public String getStatus() {
        return this.status;
    }


	public void setStatus(String status) {
        this.status = status;
    }

	

	public String getSort() {
        return this.sort;
    }


	public void setSort(String sort) {
        this.sort = sort;
    }

	
	public Date getCreateTime() {
        return this.createTime;
    }


	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}