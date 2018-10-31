/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserAttentionService.java
  * 作    者：刘广平
  * 创建日期：2018-10-18
  * </pre>
  */
package com.dl.common.service.user;

import java.util.List;

import com.dl.common.base.BaseService;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.model.entity.user.User;
import com.dl.common.model.entity.user.UserAttention;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface UserAttentionService extends BaseService<UserAttention> {
    
	/**
	 * 关注某人
	 * @param request
	 */
	public void attention(UserRequest request);
	
	/**
	 * 取关某人
	 * @param request
	 */
	public void cancelAttention(UserRequest request);
	
	/**
	 * 获取关注人列表
	 * @param request
	 * @return
	 */
	public List<User> attentionList(UserRequest request);
	
	/**
	 * 获取粉丝列表
	 * @param request
	 * @return
	 */
	public List<User> fansList(UserRequest request);
}