package com.dl.common.model.base;

import org.apache.commons.lang3.StringUtils;

public enum ResponseCodeEnum {
	
	//--------------------------------------------------- 基础类异常 --------------------------------------------------//
	SUCCESS("000000","成功"),
	FALSE("000001","系统异常"),
	NET_TIMEOUT("000002","网络异常"),
	REQ_PARAM_EMPTY("000003","入参为空值"),
	REQ_PARAM_ERROR("000004","入参异常"),
	PARAM_NULL_ERROR("000005","空指针异常"),
	REPEAT_REQUEST("000006","重复请求"),
	INVALID_REQUEST("000007","不合法请求"),
	REDIS_ERROR("000011","redis异常"),
	REDIS_CONNECT_ERROR("000012","redis连接异常"),
	REDIS_NO_CONNECT("000013","redis没有连接"),
	MYSQL_ERROR("000020","数据库异常"),
	MYSQL_INSERT_ERROR("000021","数据库插入异常"),
	MYSQL_UPDATE_ERROR("000022","数据库更新异常"),
	MYSQL_SELECT_ERROR("000023","数据库查询异常"),
	MYSQL_REPEAT_INSERT("000024","重复操作"),
	
	//--------------------------------------------------- 业务类异常 --------------------------------------------------//
	STORY_NOT_EXIST("100001","故事不存在 "),
	
	
	
	
	//--------------------------------------------------- 用户类异常 --------------------------------------------------//
	USER_NOT_EXIST("200001","用户不存在"),
	USERNAME_OR_PASSWD_ERROR("200002","用户名或密码错误"),
	MOBILE_VERIFY_CODE_ERROR("200003","验证码输入错误"),
	NOT_SUPPORT_LOGIN_TYPE("200004","不支持当前登录方式"),
	NEED_RELOGIN("200005","需重新登录"),
	NO_AUTH("200006","用户没有操作权限"),
	PASSWD_ERROR("200007","密码错误"),
	LOGIN_ERROR_LIMIT_TIMES("200008","登录失败次数过多"),
	ACCOUT_LOCK("200009","账号被锁定"),
	ACCOUT_CANNOT_USE("200010","帐号已被禁用"),
	ACCOUNT_EXPIRED("200011","账号已过期"),
	ACCOUNT_NO_AUTH("200012","用户没有登录认证"),
	;
	
	public String code;
	public String desc;
	
	ResponseCodeEnum(String code,String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public static String getMsg(String code){
		if(StringUtils.isEmpty(code)){
			return null;
		}
		for(ResponseCodeEnum codeEnum : ResponseCodeEnum.values()){
			if(codeEnum.code.equals(code)){
				return codeEnum.desc;
			}
		}
		return null;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
