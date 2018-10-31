/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：StoryOutline.java
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
 * 数据库表名称：tbl_story_outline
 * </pre>
 */
public class StoryOutline extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：版本号
     * 数据库字段信息:version VARCHAR(20)
     */
	private String version;

    /**
     * 字段名称：根故事id
     * 数据库字段信息:rootId BIGINT(19)
     */
	private String rootId;

    /**
     * 字段名称：父故事id
     * 数据库字段信息:parentId BIGINT(19)
     */
	private String parentId;

    /**
     * 字段名称：所在层级
     * 数据库字段信息:levelNum INT(10)
     */
	private String levelNum;

    /**
     * 字段名称：子故事数
     * 数据库字段信息:childNum INT(10)
     */
	private String childNum;

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

    public StoryOutline() {
    }	

	

	public String getVersion() {
        return this.version;
    }


	public void setVersion(String version) {
        this.version = version;
    }

	

	public String getRootId() {
        return this.rootId;
    }


	public void setRootId(String rootId) {
        this.rootId = rootId;
    }

	

	public String getParentId() {
        return this.parentId;
    }


	public void setParentId(String parentId) {
        this.parentId = parentId;
    }

	

	public String getLevelNum() {
        return this.levelNum;
    }


	public void setLevelNum(String levelNum) {
        this.levelNum = levelNum;
    }

	

	public String getChildNum() {
        return this.childNum;
    }


	public void setChildNum(String childNum) {
        this.childNum = childNum;
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