package com.dl.common.framework.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.dl.common.framework.exception.DlException;
import com.dl.common.framework.logger.LoggerUtil;
import com.dl.common.framework.redis.redisKey.RedisSwitchKey;
import com.dl.common.framework.redis.template.RedisSwitchTemplate;
import com.dl.common.model.base.ResponseCodeEnum;

/**
 * 请求过滤器：
 * 	1、获取安全校验开关
 * 	2、解密密文，转换明文
 * 	2、重复点击
 * 	3、非法请求
 * @author levi.liu
 *
 */
public class DecryptFilter implements Filter{
	
	@Autowired
	private RedisSwitchTemplate switchTemplate;
	
	//需要安全校验的请求路径
	private static Map<String, Integer> checkList;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		try {
			//1、获取开关，存储req，向下传递
			servletRequest.setAttribute(RedisSwitchKey.DECRYPT_SWITCH, getSwitchMap());
			//2、安全性校验：重复点击、非法请求、
			if(checkList.containsKey(((HttpServletRequest)servletRequest).getServletPath())){
				//TODO获取参与安全校验的头部参数
				Map<String, String> decMap = new HashMap<>();
				//TODO重复点击：token + url 存储redis指定时间，请求校验redis存在，则判定重复请求
				
				//TODO非法请求：根据头部参数，加密校验
			}
			filterChain.doFilter(servletRequest, servletResponse);
		} catch (Exception e) {
			if(e instanceof DlException){
				DlException dlException = (DlException) e;
				//打印 日志
//				writeLog(servletRequest,dlException.getErrorCode(),dlException.getErrorMsg(),dlException);
				//跳转逻辑
				servletRequest.setAttribute("code", dlException.getErrorCode());
				servletRequest.getRequestDispatcher("/exception/requestWarning").forward(servletRequest, servletResponse);
			} else {
				LoggerUtil.error("[DecryptFilter][doFilter][Exception]", e);
			}
		} 
	}

	/**
	 * 获取安全校验开关，如果redis不存在，使用默认值
	 * @return
	 */
	private Map<String, Object> getSwitchMap(){
		Map<String, Object> switchMap = switchTemplate.getSwitchDefault(null);
		if(null == switchMap){
			return RedisSwitchKey.getSwitchMapDefault();
		} 
		return switchMap;
	}
	
	private void writeLog(ServletRequest request,String errorCode,String errorMsg){
		//重复点击不打印日志
		if(ResponseCodeEnum.REPEAT_REQUEST.code.equals(errorCode)){
			return;
		}
		LoggerUtil.error(System.lineSeparator());
		LoggerUtil.error("=================================log start==================================");
		LoggerUtil.error("IlleageRequest："+errorCode+"--"+errorMsg);
		LoggerUtil.error("reqUrl："+((HttpServletRequest)request).getServletPath());
//		LoggerUtil.error("currentTime："+ String.valueOf( decMap.get("t")));//时间戳
//		LoggerUtil.error("mDeviceId："+ String.valueOf(decMap.get("d")));//设备号
//		LoggerUtil.error("mSignedDeviceId："+ String.valueOf(decMap.get("s")));//加密sign
//		LoggerUtil.error("accessUserId："+ String.valueOf(decMap.get("u")));//用户id
//		LoggerUtil.error("accessToken："+String.valueOf(decMap.get("a")));//用户token
//		LoggerUtil.error("version："+String.valueOf(decMap.get("v")));//用户token
		LoggerUtil.error("terminalType："+((HttpServletRequest)request).getHeader("terminalType"));//终端类型
//				记录异常日志
//		LoggerUtil.error(t.getMessage(),t);
		LoggerUtil.error("=================================log end==================================");
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//项目初始化时，缓存需要校验的请求列表
		checkList = new HashMap<>();
		checkList.put("/story/insertStory", 1);
	}
	
	@Override
	public void destroy() {}

}
