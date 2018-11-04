package com.dl.common.utils.common;

/**
 * 16进制工具类
 * 
 * @author levi.liu
 *
 */
public class HexUtil {

	/**
	 * 二进制转换成16进制字符串
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	
	/**
	 * 10进制转换成16进制字符串
	 * @param data
	 * @return
	 */
	public static String parseInt2HexStr(int data){
		return Integer.toHexString(data);
	}
	
	/**
	 * 16进制转换成10进制
	 * @param hexStr
	 * @return
	 */
	public static int parseHexStr2Int(String hexStr){
		return Integer.parseInt(hexStr, 16);
	}
	
	/**
	 * String 转 ASCII 码
	 * @param original
	 * @return
	 */
	public static String str2Ascii(String  original){   
        byte[] bytes = original.getBytes();   
        String hs = "";   
        for (int n = 0; n < bytes.length; n++){   
            hs += (Integer.toHexString(bytes[n] & 0XFF));   
        }   
        return hs.toUpperCase();   
	}
	
	/**
	 * ASCII 码转 String
	 * @param hex
	 * @return
	 */
	public static String ascii2Str(String hex) {
	    if (hex == null || hex.equals("")) {
	        return null;
	    }
	    hex = hex.replace(" ", "");
	    byte[] baKeyword = new byte[hex.length() / 2];
	    for (int i = 0; i < baKeyword.length; i++) {
	        try {
	            baKeyword[i] = (byte) (0xff & Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    try {
	    	hex = new String(baKeyword, "UTF-8");
	        new String();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    return hex;
	}
}
