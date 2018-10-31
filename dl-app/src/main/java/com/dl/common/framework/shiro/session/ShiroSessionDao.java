package com.dl.common.framework.shiro.session;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.dl.common.framework.redis.template.RedisCommonTemplate;

@Component
public class ShiroSessionDao extends CachingSessionDAO{

	@Autowired
	private RedisCommonTemplate redisTemplate;
	
	private static int DEFAULT_INDEX = 3;
	
	@Override
	protected void doDelete(Session session) {
		System.out.println("doDelete:"+JSONObject.toJSONString(session));
		
	}

	@Override
	protected void doUpdate(Session session) {
		if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
			 return; //如果会话过期/停止 没必要再更新了
		} 
		redisTemplate.StoreKey(null,DEFAULT_INDEX, JSONObject.toJSONString(session.getId()), JSONObject.toJSONString(session));
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		redisTemplate.StoreKey(null, DEFAULT_INDEX,JSONObject.toJSONString(sessionId), JSONObject.toJSONString(session));
		return session.getId(); 
	}

	@Override
	protected Session doReadSession(Serializable sessioId) {
		String sessionStr =  (String) redisTemplate.getValue(null, DEFAULT_INDEX, JSONObject.toJSONString(sessioId));
		if(StringUtils.isEmpty(sessionStr)){
			return null;
		}
		return JSONObject.parseObject(sessionStr, Session.class);
	}

}
