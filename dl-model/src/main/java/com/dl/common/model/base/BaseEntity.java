package com.dl.common.model.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类，包含各实体公用属性 
 * @author Liugp
 *
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String userId;
	private String version;
	protected Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
