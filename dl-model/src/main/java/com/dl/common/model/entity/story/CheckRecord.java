/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：CheckRecord.java
  * 作    者：刘广平
  * 创建日期：2018-9-4
  * </pre>
  */
package com.dl.common.model.entity.story;

import com.dl.common.model.base.BaseEntity;
import java.util.Date;

/**
 * <pre>
 * 实体类
 * 数据库表名称：tbl_check_record
 * </pre>
 */
public class CheckRecord extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：故事ID
     * 数据库字段信息:storyId BIGINT(19)
     */
	private String storyId;

    /**
     * 字段名称：2：审核通过，3：审核不通过
     * 数据库字段信息:status INT(10)
     */
	private String status;

    /**
     * 字段名称：审核人id
     * 数据库字段信息:checkBy BIGINT(19)
     */
	private String checkBy;

    /**
     * 字段名称：备注
     * 数据库字段信息:remark VARCHAR(100)
     */
	private String remark;

    /**
     * 字段名称：审核时间
     * 数据库字段信息:checkDate DATETIME(19)
     */
	private Date checkDate;

    public CheckRecord() {
    }	

	

	public String getStoryId() {
        return this.storyId;
    }


	public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

	

	public String getStatus() {
        return this.status;
    }


	public void setStatus(String status) {
        this.status = status;
    }

	

	public String getCheckBy() {
        return this.checkBy;
    }


	public void setCheckBy(String checkBy) {
        this.checkBy = checkBy;
    }

	

	public String getRemark() {
        return this.remark;
    }


	public void setRemark(String remark) {
        this.remark = remark;
    }

	
	public Date getCheckDate() {
        return this.checkDate;
    }


	public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }


}