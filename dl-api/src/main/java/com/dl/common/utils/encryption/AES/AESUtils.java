package com.dl.common.utils.encryption.AES;

import org.apache.commons.lang3.StringUtils;
import com.dl.common.utils.common.HexUtil;
import com.dl.common.utils.encryption.base64.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 对称加密：
 * @author levi.liu
 *
 */
public class AESUtils {
	// 注意: 这里的password(秘钥必须是16位的)
	public static final String AES_KEY = "QB_DeF_aB_DefgQw";
	private static final String ALGORITHM_STR = "AES/ECB/PKCS5Padding";

	/**
	 * 执行加密算法，基于16进制字符串，返回String
	 * @param content
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String doEncryptStr(String content, String password) throws Exception {
		byte[] encryptByte = doEncrypt(content, password);
		return HexUtil.parseByte2HexStr(encryptByte);
	}
	
	/**
	 * 执行加密算法，返回字节数组
	 * @param content
	 * @param password
	 * @return
	 */
	public static byte[] doEncrypt(String content, String password) throws Exception {
		SecretKeySpec key = new SecretKeySpec(getKey(password), "AES");
		Cipher cipher = Cipher.getInstance(ALGORITHM_STR);// algorithmStr
		cipher.init(Cipher.ENCRYPT_MODE, key);// ʼ
		return cipher.doFinal(content.getBytes("utf-8"));
	}
	
	public static String doDecryptStr(String content, String password) throws Exception {
		return doDecrypt(HexUtil.parseHexStr2Byte(content), password);
	}
	
	/**
	 * 执行解密算法
	 * @param content
	 * @param password
	 * @return byte[]
	 */
	public static String doDecrypt(byte[] content, String password) throws Exception {
		SecretKeySpec key = new SecretKeySpec(getKey(password), "AES");
		Cipher cipher = Cipher.getInstance(ALGORITHM_STR);// algorithmStr
		cipher.init(Cipher.DECRYPT_MODE, key);// ʼ
		return new String(cipher.doFinal(content),"UTF-8"); //
	}

	/**
	 * 获取passwoed的byte数组
	 * @param password
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
	 * 使用默认key对content加密，基于Base64编码返回字符串
	 * @param content
	 * @return String
	 */
	public static String encrypt(String content) throws Exception {
		return encrypt(content, AES_KEY);
	}

	/**
	 * 使用指定的aesKey对content加密,基于Base64编码返回字符串
	 * @param content 需要加密的内容
	 * @param aesKey aes加密的key
	 * @return String : 加密后的字符串
	 */
	public static String encrypt(String content, String aesKey) throws Exception {
		if (isEmpty(content)) {
			throw new Exception("---------加密内容为空---------");
		}
		if (StringUtils.isEmpty(aesKey)) {
			aesKey = AES_KEY;
		}
		// 执行加密
		byte[] encodeByte = doEncrypt(content, aesKey);
		String base64Str = Base64.encode(encodeByte);
		return base64Str;
	}

	/**
	 * 使用默认key对content解密
	 * @param content
	 * @return String
	 */
	public static String decrypt(String content) throws Exception {
		return decrypt(content, AES_KEY);
	}

	/**
	 * 使用指定的aesKey对content解密
	 * @param content 需要解密的内容
	 * @param aesKey aes解密的key
	 * @return String : 解密后的字符串
	 */
	public static String decrypt(String content, String aesKey) throws Exception {
		if (isEmpty(content)) {
			throw new Exception("---------解密内容为空---------");
		}
		if (StringUtils.isEmpty(aesKey)) {
			aesKey = AES_KEY;
		}
		return doDecrypt(Base64.decode(content), aesKey);
	}

	/**
	 * 校验字符串是否为空
	 * @param content String
	 * @return 为空返回true 否则返回false
	 */
	private static boolean isEmpty(String content) {
		return StringUtils.isEmpty(content);
	}
	
	public static void main(String[] args) {
		try {
			String content = "111111111111111111111111111111112222222222222222222222222222222233333333333333333333333333333333";
			String password = "23dsjr3er3e23eer";
			String encry = doEncryptStr(content, password);
			System.out.println("加密后数据:"+encry);
			String decry = doDecryptStr(encry, password);
			System.out.println("解密后数据:"+decry);
			
			String encry1 = encrypt(content, password);
			System.out.println("加密后数据:"+encry1);
			String decry1 = decrypt(encry1, password);
			System.out.println("解密后数据:"+decry1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
