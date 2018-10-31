/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：Channel.java
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
 * 数据库表名称：tbl_channel
 * </pre>
 */
public class Channel extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：版本号
     * 数据库字段信息:version VARCHAR(20)
     */
	private String version;

    /**
     * 字段名称：编码
     * 数据库字段信息:channelCode INT(10)
     */
	private String channelCode;

    /**
     * 字段名称：板块名
     * 数据库字段信息:channelName VARCHAR(10)
     */
	private String channelName;

    /**
     * 字段名称：排序
     * 数据库字段信息:sort INT(10)
     */
	private Integer sort;
	
	/**
     * 字段名称：板块缓存故事上限
     * 数据库字段信息:cacheLimit INT(10)
     */
	private Integer cacheLimit;

    /**
     * 字段名称：是否默认（0：否，1：是）
     * 数据库字段信息:isDefault INT(10)
     */
	private Integer isDefault;

    /**
     * 字段名称：状态（0：禁用，1：启用）
     * 数据库字段信息:status INT(10)
     */
	private Integer status;

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

    public Channel() {
    }	

	public String getVersion() {
        return this.version;
    }


	public void setVersion(String version) {
        this.version = version;
    }

	public String getChannelCode() {
        return this.channelCode;
    }


	public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

	public String getChannelName() {
        return this.channelName;
    }


	public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

	public Date getCreateTime() {
        return this.createTime;
    }


	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Integer getSort() {
		return sort;
	}



	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getIsDefault() {
		return isDefault;
	}



	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}



	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdateTime() {
        return this.updateTime;
    }

	public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public Integer getCacheLimit() {
		return cacheLimit;
	}

	public void setCacheLimit(Integer cacheLimit) {
		this.cacheLimit = cacheLimit;
	}

}