//package com.dl.common.framework.shiro.session;
//
//import java.io.Serializable;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.mgt.SessionContext;
//import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.apache.shiro.web.util.WebUtils;
//
//import com.alibaba.fastjson.JSONObject;
//
//public class ShiroSessionManager extends DefaultWebSessionManager{
//	
//	public static final String TOKEN = "accesstoken";
//	public static final String USER_ID = "accessuserid";
//	private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
//
//	public ShiroSessionManager(){
//        super();
//    }
// 
//    @Override
//    protected Serializable getSessionId(ServletRequest request, ServletResponse response){
//    	System.out.println(JSONObject.toJSONString(WebUtils.toHttp(request).getRequestURL()));
//        String token = WebUtils.toHttp(request).getHeader(TOKEN);
//        String userId = WebUtils.toHttp(request).getHeader(USER_ID);
//        if(StringUtils.isEmpty(userId)){
//            //如果没有携带id参数则按照父类的方式在cookie进行获取
//            return super.getSessionId(request, response);
//        }else{
//            //如果请求头中有 authToken 则其值为sessionId
//        	request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,REFERENCED_SESSION_ID_SOURCE);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID,"AAAAAAAAAAAAAAAAAAAAAAAAAAA");
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);
//            return "AAAAAAAAAAAAAAAAAAAAAAAAAAA";
//        }
//    }
//
//}
