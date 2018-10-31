/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：User.java
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
 * 数据库表名称：tbl_user
 * </pre>
 */
public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;

    /**
     * 字段名称：verison
     * 数据库字段信息:version VARCHAR(20)
     */
	private String version;

    /**
     * 字段名称：登录名
     * 数据库字段信息:loginName VARCHAR(20)
     */
	private String loginName;

    /**
     * 字段名称：昵称
     * 数据库字段信息:nickName VARCHAR(20)
     */
	private String nickName;

    /**
     * 字段名称：微信账号
     * 数据库字段信息:wxAccount VARCHAR(30)
     */
	private String wxAccount;

    /**
     * 字段名称：QQ账号
     * 数据库字段信息:qqAccount VARCHAR(15)
     */
	private String qqAccount;
	
	/**
     * 字段名称：微博账号
     * 数据库字段信息:wbAccount VARCHAR(15)
     */
	private String wbAccount;

    /**
     * 字段名称：手机号
     * 数据库字段信息:mobileNo VARCHAR(15)
     */
	private String mobileNo;

    /**
     * 字段名称：邮箱
     * 数据库字段信息:email VARCHAR(20)
     */
	private String email;

    /**
     * 字段名称：密码
     * 数据库字段信息:password VARCHAR(40)
     */
	private String password;

    /**
     * 字段名称：性别（0：未知，1：男，2：女）
     * 数据库字段信息:sex INT(10)
     */
	private String sex;

    /**
     * 字段名称：生日
     * 数据库字段信息:birth VARCHAR(10)
     */
	private String birth;

    /**
     * 字段名称：签名
     * 数据库字段信息:remark VARCHAR(100)
     */
	private String remark;

    /**
     * 字段名称：类型（0：游客，1：APP注册用户）
     * 数据库字段信息:type INT(10)
     */
	private String type;

    /**
     * 字段名称：状态（0：禁用，1：启用）
     * 数据库字段信息:status INT(10)
     */
	private String status;

    /**
     * 字段名称：是否管理员（0：否，1：是）
     * 数据库字段信息:isManager INT(10)
     */
	private String isManager;

    /**
     * 字段名称：图像地址
     * 数据库字段信息:imgUrl VARCHAR(100)
     */
	private String imgUrl;

    /**
     * 字段名称：输错密码次数
     * 数据库字段信息:pwdErrorCount INT(10)
     */
	private String pwdErrorCount;

    /**
     * 字段名称：用户token
     * 数据库字段信息:token VARCHAR(40)
     */
	private String token;

    /**
     * 字段名称：地址
     * 数据库字段信息:address VARCHAR(100)
     */
	private String address;

    /**
     * 字段名称：关注数
     * 数据库字段信息:followCount INT(10)
     */
	private String followCount;

    /**
     * 字段名称：粉丝人数
     * 数据库字段信息:fansCount INT(10)
     */
	private String fansCount;
	
	/**
     * 发布故事数（审核通过为标准）
     * 数据库字段信息:storyCount INT(6)
     */
	private String storyCount;

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

    public User() {
    }	

	

	public String getVersion() {
        return this.version;
    }


	public void setVersion(String version) {
        this.version = version;
    }

	

	public String getLoginName() {
        return this.loginName;
    }


	public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

	

	public String getNickName() {
        return this.nickName;
    }


	public void setNickName(String nickName) {
        this.nickName = nickName;
    }

	

	public String getWxAccount() {
        return this.wxAccount;
    }


	public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

	

	public String getQqAccount() {
        return this.qqAccount;
    }


	public void setQqAccount(String qqAccount) {
        this.qqAccount = qqAccount;
    }

	

	public String getMobileNo() {
        return this.mobileNo;
    }


	public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

	

	public String getEmail() {
        return this.email;
    }


	public void setEmail(String email) {
        this.email = email;
    }

	

	public String getPassword() {
        return this.password;
    }


	public void setPassword(String password) {
        this.password = password;
    }

	

	public String getSex() {
        return this.sex;
    }


	public void setSex(String sex) {
        this.sex = sex;
    }

	

	public String getBirth() {
        return this.birth;
    }


	public void setBirth(String birth) {
        this.birth = birth;
    }

	

	public String getRemark() {
        return this.remark;
    }


	public void setRemark(String remark) {
        this.remark = remark;
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

	

	public String getIsManager() {
        return this.isManager;
    }


	public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

	

	public String getImgUrl() {
        return this.imgUrl;
    }


	public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

	

	public String getPwdErrorCount() {
        return this.pwdErrorCount;
    }


	public void setPwdErrorCount(String pwdErrorCount) {
        this.pwdErrorCount = pwdErrorCount;
    }

	

	public String getToken() {
        return this.token;
    }


	public void setToken(String token) {
        this.token = token;
    }

	

	public String getAddress() {
        return this.address;
    }


	public void setAddress(String address) {
        this.address = address;
    }

	

	public String getFollowCount() {
        return this.followCount;
    }


	public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }

	

	public String getFansCount() {
        return this.fansCount;
    }


	public void setFansCount(String fansCount) {
        this.fansCount = fansCount;
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

	public String getWbAccount() {
		return wbAccount;
	}

	public void setWbAccount(String wbAccount) {
		this.wbAccount = wbAccount;
	}

	public String getStoryCount() {
		return storyCount;
	}

	public void setStoryCount(String storyCount) {
		this.storyCount = storyCount;
	}

}