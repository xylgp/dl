package com.dl.common.model.app.req;

import java.util.List;

import com.dl.common.model.base.BaseEntity;

/**
 * 用户
 * @author Levi.Liu
 */
public class UserResponse extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	//昵称
	private String nickName;
	
	//签名
	private String signature;
	
	//图像地址
	private String imgUrl;
	
	//Token
	private String token;
	
	private String remark;
	
	private List<String> authList;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getAuthList() {
		return authList;
	}

	public void setAuthList(List<String> authList) {
		this.authList = authList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
