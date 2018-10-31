package com.dl.common.config;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.PropertyResourceBundle;
import com.dl.common.framework.logger.LoggerUtil;

public class ParamProps {

	// 用户相关请求参数校验
	public static String USER_LOGIN;// 登录、注册请求参数
	public static String REFRESH_TOKEN;// 校验token是否有效
	public static String USER_ATTENTION;// 用户新增关注
	public static String USER_CANCELATTENTION;// 用户取消关注
	public static String USER_ATTENTIONLIST;// 用户关注列表
	public static String USER_FANSLIST;// 用户粉丝列表
	public static String USER_UPDATEINFO;// 修改用户信息
	public static String USER_USERINFO;// 查询用户信息

	// 故事相关请求参数校验
	public static String CHANNEL_INSERTCHANNEL;// 保存用户自定义板块
	public static String CHANNEL_USERCHANNEL;// 获取用户自定义板块
	public static String STORY_INSERTSTORY;// 新增故事
	public static String STORY_STORYOUTLINE;// 查询故事大纲
	public static String STORY_CHECKLIST;// 查询待审核列表
	public static String STORY_CHECKSTORY;// 审核故事
	public static String STORY_STORYCONTENT;// 查询故事详情
	public static String STORY_STORYCONTENTDYANMIC;// 查询故事详情

	// 交易相关请求参数校验
	
	/**
	 * 加载系统配置项
	 */
	public static void loadDefinitions() {
		try {
			InputStream fis = ParamProps.class.getClassLoader().getResourceAsStream("properties/param.properties");
			PropertyResourceBundle props = new PropertyResourceBundle(fis);

			Class<?> clazz = ParamProps.class;
			Field[] fields = clazz.getDeclaredFields();
			Object obj = clazz.newInstance();
			for (Field f : fields) {
				f.set(obj, props.getString(f.getName()));
			}

			props = null;
			fis.close();
			fis = null;
		} catch (Exception e) {
			LoggerUtil.error("props >> Read config info error", e);
		}
	}
	
	public static String getValue(String url){
		try {
			String ul = url.replaceAll("/", "_");
			Field[] fields = ParamProps.class.getDeclaredFields();
			for(Field field : fields){
				if(ul.toUpperCase().endsWith(field.getName())){
					return (String) field.get(new ParamProps());
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 打印配置项
	 */
	public static void print() {
		StringBuilder builder = new StringBuilder("-----------------------------------------------------------\n");
		try {
			Class<?> clazz = ParamProps.class;
			Field[] fields = clazz.getDeclaredFields();
			Object obj = clazz.newInstance();
			for (Field f : fields) {
				builder.append(f.getName() + "=" + f.get(obj) + System.lineSeparator());
			}
			builder.append("-----------------------------------------------------------");
		} catch (Exception e) {
			LoggerUtil.error("props >> print configuration error", e);
		}
		LoggerUtil.info(builder.toString());
	}
}
