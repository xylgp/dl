package com.dl.common.model.app.req;

import java.util.List;

import com.dl.common.model.base.BaseEntity;
import com.dl.common.model.entity.user.User;

public class UserRequest extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	//登录方式：1--账户名、密码登录，2--qq登录，3--微信登录，4--微博登录
	private int loginType;
	
	//用户名：账户名、qq号、微信号、微博号
	private String userName;
	
	//加前缀用户名
	private String fullUserName;
	
	//密码：账户密码、QQ认证、微信认证、微博认证
	private String passwd;
	
	//用户token
	private String token;
	
	//用户昵称
	private String nickName;
	
	//图像地址
	private String imgUrl;
	
	//生日
	private String birth;
	
	//性别：1：男，2：女
	private String sex;
	
	//签名
	private String remark;
	
	//地址
	private String address;
	
	//时间戳
	private Long timestamp;
	
	//是否注册
	private User user;
	
	//后台计算的密码
	private String buildPassWd;
	
	//角色列表
	private List<String> roleList;
	
	//权限列表
	private List<String> authList;
	
	private String attentionId;

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getFullUserName() {
		return fullUserName;
	}

	public void setFullUserName(String fullUserName) {
		this.fullUserName = fullUserName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

	public List<String> getAuthList() {
		return authList;
	}

	public void setAuthList(List<String> authList) {
		this.authList = authList;
	}

	public String getBuildPassWd() {
		return buildPassWd;
	}

	public void setBuildPassWd(String buildPassWd) {
		this.buildPassWd = buildPassWd;
	}

	public String getAttentionId() {
		return attentionId;
	}

	public void setAttentionId(String attentionId) {
		this.attentionId = attentionId;
	}
	
}
