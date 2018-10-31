package com.dl.common.utils.common;

/**
 * String 工具类
 * @author Levi.liu
 *
 */
public class StringUtils {
	
	/**
	 * String 转 16进制
	 * @param original
	 * @return
	 */
	public static String Str2Ascii(String  original){   
        byte[] bytes = original.getBytes();   
        String hs = "";   
        for (int n = 0; n < bytes.length; n++){   
            hs += (Integer.toHexString(bytes[n] & 0XFF));   
        }   
        return hs.toUpperCase();   
	}
	
	public static String Ascii2Str(String hex) {
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
	
	public static void main(String[] args) {
		System.out.println(Str2Ascii("weqw213213"));
		System.out.println(Ascii2Str("77657177323133323133"));
	}
}
