package com.dl.common.utils.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import com.dl.common.model.entity.user.User;
import com.dl.common.utils.encryption.md5.MD5Util;

public class UIDUtils {
	
	/**
	 * 构建18位id
	 * @return
	 */
	public static String generateID(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.valueOf(System.currentTimeMillis()));
		buffer.append(new SimpleDateFormat("ssSSS").format(new Date()));
		return buffer.toString();
	}
	
	/**
	 * 获取最大的Id：时间戳使用2200年12月30日
	 * @return
	 */
	public static String generateMaxId(){
		return "728953919900000000";
	}
	
	/**
	 * 生成token:当前时间yyMMddhhssmm  + loginName + 8位随机数 + 用户ID，然后base64
	 * @param userId
	 * @return
	 */
	public static String generateToken(User user){
		StringBuffer buffer = new StringBuffer();
		buffer.append(new SimpleDateFormat("yyMMddHHmmss").format(new Date())); //当前时间yyMMddhhssmm
		buffer.append(user.getLoginName()); //loginName
		buffer.append(generateRandomNumAndStr(8)); //8位随机数
		buffer.append(user.getId());  //用户ID
		return MD5Util.string2MD5(buffer.toString());
	}
	
	public static String generateRandomNum(int length){
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		for(int i = 0 ; i < length ; i++ ){
			buffer.append(random.nextInt(10));
		}
		return buffer.toString();
	}
	
	/**
	 * 生成指定位数的数字+字母的随机数
	 * @param length
	 * @return
	 */
	public static String generateRandomNumAndStr(int length){
		StringBuffer buffer = new StringBuffer();
		int times = length / 32;
		for(int i = 0 ; i < times ; i++ ){
			buffer.append(generate32Uid());
		}
		buffer.append(generate32Uid().substring(32-length%32));
		return buffer.toString();
	}
	
	/**
	 * 生成32位长度的随机数
	 * @return
	 */
	public static String generate32Uid(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
