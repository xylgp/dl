package com.dl.common.model.enums;

/**
 * 登录类型枚举类
 * @author Levi.liu
 */
public enum LoginTypeEnum {
	
	LOGIN_TYPE_USERNAME(1,"","账号、密码登录"),
	LOGIN_TYPE_MOBILE(2,"MB","手机号登录"),
	LOGIN_TYPE_QQ(3,"QQ","QQ号登录"),
	LOGIN_TYPE_WX(4,"WX","微信登录"),
	LOGIN_TYPE_WB(5,"WB","微博登录"),
	;
	
	public int type;
	public String prefix;
	public String desc;
	
	private LoginTypeEnum(int type,String prefix,String desc) {
		this.type = type;
		this.prefix = prefix;
		this.desc = desc;
	}
	
	public static LoginTypeEnum parse(int type){
		if(type == 0) return null;
		for(LoginTypeEnum loginTypeEnum : LoginTypeEnum.values()){
			if(type == loginTypeEnum.getType()){
				return loginTypeEnum;
			}
		}
		return null;
	}
	
	public static String buildLoginName(int type,String userName){
		if(type == 0) return null;
		for(LoginTypeEnum loginTypeEnum : LoginTypeEnum.values()){
			if(type == loginTypeEnum.getType()){
				return loginTypeEnum.prefix + userName;
			}
		}
		return null;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
