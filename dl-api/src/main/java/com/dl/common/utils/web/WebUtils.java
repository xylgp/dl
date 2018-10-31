package com.dl.common.utils.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import com.dl.common.framework.logger.LoggerUtil;

public class WebUtils {

	/**
	 * 读取request body 
	 * @param request
	 * @return
	 */
	public static String readBody(HttpServletRequest request){
		BufferedReader br = null;
        try {
            StringBuilder result = new StringBuilder();
            br = request.getReader();
            for (String line=null;br != null && (line=br.readLine())!=null;) {
                result.append(line).append("\n");
            }

            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (br != null )
                try {br.close();
                    request.getReader().close();
            } catch (IOException e) {
            	LoggerUtil.error(e.getMessage(), e);
            }
        }
	}
	
	/**
	 * 获取客户端IP
	 * @param request
	 * @return
	 */
    public static final String getHost(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip != null && ip.indexOf(",") > 0) {
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            ip = ip.substring(0, ip.indexOf(","));
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
            InetAddress inet = null;
            try { // 根据网卡取本机配置的IP
                inet = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                LoggerUtil.error("获取ip错误 ", e);
            }
            ip = inet.getHostAddress();
        }
        return ip;
    }
}
