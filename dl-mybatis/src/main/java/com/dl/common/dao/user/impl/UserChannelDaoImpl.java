/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserChannelDaoImpl.java
  * 作    者：刘广平
  * 创建日期：2018-8-24
  * </pre>
  */
package com.dl.common.dao.user.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDaoImpl;
import com.dl.common.model.app.req.ChannelResponse;
import com.dl.common.model.entity.user.UserChannel;
import com.dl.common.dao.user.UserChannelDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("UserChannelDao")
public class UserChannelDaoImpl extends BaseDaoImpl<UserChannel> implements UserChannelDao {

	@Override
	public void batchDeleteByUserId(String userId) {
		sessionTemplate.delete(getStatement("batchDeleteByUserId"), userId);
	}

	@Override
	public List<ChannelResponse> getUserChannelList(String userId) {
		return sessionTemplate.selectList(getStatement("selectUserChannelList"), userId);
	}
	

}