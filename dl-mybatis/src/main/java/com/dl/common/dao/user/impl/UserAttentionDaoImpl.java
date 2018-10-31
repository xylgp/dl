/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserAttentionDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-10-18
  * </pre>
  */
package com.dl.common.dao.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.entity.user.User;
import com.dl.common.model.entity.user.UserAttention;
import com.dl.common.dao.user.UserAttentionDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("UserAttentionDao")
public class UserAttentionDaoImpl extends BaseDaoImpl<UserAttention> implements UserAttentionDao {

	@Override
	public void cancelAttention(String userId, String attentionId) {
		Map<String, String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("attentionId", attentionId);
		sessionTemplate.update("cancelAttention", map);
	}

	@Override
	public void deleteAttention(String userId, String attentionId) {
		Map<String, String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("attentionId", attentionId);
		sessionTemplate.delete("deleteAttention", map);
	}
	
	@Override
	public List<User> attentionList(String userId) {
		return sessionTemplate.selectList("attentionList", userId);
	}

	@Override
	public List<User> fansList(String attentionId) {
		return sessionTemplate.selectList("fansList", attentionId);
	}

	

}