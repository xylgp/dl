package com.dl.common.utils.encryption.AES;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dl.common.utils.encryption.base64.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
	// 注意: 这里的password(秘钥必须是16位的)
	public static final String AES_KEY = "QB_DeF_aB_DefgQw";
	private static final String ALGORITHM_STR = "AES/ECB/PKCS5Padding";
	private static final Logger logger = LoggerFactory.getLogger(AESUtils.class);

	/**
	 * 执行加密算法
	 * 
	 * @param content
	 *            : String
	 * @param password
	 *            : String
	 * @return
	 */
	private static byte[] doEncrypt(String content, String password) throws Exception {
		SecretKeySpec key = new SecretKeySpec(getKey(password), "AES");
		Cipher cipher = Cipher.getInstance(ALGORITHM_STR);// algorithmStr
		cipher.init(Cipher.ENCRYPT_MODE, key);// ʼ
		return cipher.doFinal(content.getBytes("utf-8")); //
	}

	/**
	 * 执行解密算法
	 * 
	 * @param content
	 *            : String
	 * @param password
	 *            : String
	 * @return byte[]
	 */
	private static byte[] doDecrypt(byte[] content, String password) throws Exception {
		SecretKeySpec key = new SecretKeySpec(getKey(password), "AES");
		Cipher cipher = Cipher.getInstance(ALGORITHM_STR);// algorithmStr
		cipher.init(Cipher.DECRYPT_MODE, key);// ʼ
		return cipher.doFinal(content); //
	}

	/**
	 * 获取passwoed的byte数组
	 * 
	 * @param password
	 *            : String
	 * @return byte[]
	 */
	private static byte[] getKey(String password) {
		byte[] rByte = null;
		if (password != null) {
			rByte = password.getBytes();
		} else {
			rByte = new byte[24];
		}
		return rByte;
	}

	/**
	 * 对content加密--使用默认的aesKey进行加密
	 * 
	 * @param content
	 *            : String
	 * @return String
	 */
	public static String encryp(String content) throws Exception {
		return encryp(content, AES_KEY);
	}

	/**
	 * @Title: encryp
	 * @Description: 使用指定的aesKey对content加密
	 * @param content
	 *            : String : 需要加密的内容
	 * @param aesKey
	 *            : String : aes加密的key
	 * @return String : 加密后的字符串
	 */
	public static String encryp(String content, String aesKey) throws Exception {
		logger.debug("AES加密的内容：" + content + "\t\tAES加密的key：" + aesKey);
		if (isEmpty(content)) {
			throw new Exception("---------加密内容为空---------");
		}
		if (StringUtils.isEmpty(aesKey)) {
			aesKey = AES_KEY;
		}
		// 执行加密
		byte[] encodeByte = doEncrypt(content, aesKey);
		String base64Str = Base64.encode(encodeByte);
		logger.info("加密后的密文已Base64加密：" + base64Str);
		return base64Str;
	}

	/**
	 * 对content解密--使用默认的aesKey进行解密
	 * 
	 * @param content
	 *            : String
	 * @return String
	 */
	public static String decrypt(String content) throws Exception {
		return decrypt(content, AES_KEY);
	}

	/**
	 * @Title: encryp
	 * @Description: 使用指定的aesKey对content解密
	 * @param content
	 *            : String : 需要解密的内容
	 * @param aesKey
	 *            : String : aes解密的key
	 * @return String : 解密后的字符串
	 */
	public static String decrypt(String content, String aesKey) throws Exception {
		// logger.info("AES解密的内容："+content +"\t\tAES解密的Key：");
		if (isEmpty(content)) {
			throw new Exception("---------解密内容为空---------");
		}
		if (StringUtils.isEmpty(aesKey)) {
			aesKey = AES_KEY;
		}
		byte[] decodeByte = doDecrypt(Base64.decode(content), aesKey);
		String decodeStr = new String(decodeByte);
		// logger.info("解密后的明文已Base64解密：" + decodeStr);
		return decodeStr;
	}

	/**
	 * 校验字符串是否为空
	 * 
	 * @param content
	 *            : String
	 * @return 为空返回true 否则返回false
	 */
	private static boolean isEmpty(String content) {
		return StringUtils.isEmpty(content);
	}

}
