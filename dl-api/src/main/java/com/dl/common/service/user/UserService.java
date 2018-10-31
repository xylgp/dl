/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserService.java
  * 作    者：刘广平
  * 创建日期：2018-8-19
  * </pre>
  */
package com.dl.common.service.user;

import com.dl.common.base.BaseService;
import com.dl.common.model.app.req.UserRequest;
import com.dl.common.model.entity.user.User;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface UserService extends BaseService<User> {
    
	/**
	 * 根据登录名查询用户信息
	 * @param userName
	 * @return
	 */
	User selectByUserName(String userName);
	
	/**
	 * 根据手机号查询用户信息
	 * @param mobileNo
	 * @return
	 */
	User selectByMobileNo(String mobileNo);
	
	/**
	 * 根据微信号查询用户信息
	 * @param wxAccount
	 * @return
	 */
	User selectByWx(String wxAccount);
	
	/**
	 * 根据QQ好查询用户信息
	 * @param qqAccount
	 * @return
	 */
	User selectByQq(String qqAccount);
	
	/**
	 * 根据微博号查询用户信息
	 * @param wbAccount
	 * @return
	 */
	User selectByWb(String wbAccount);
	
	/**
	 * 修改用户信息
	 * @param userRequest
	 */
	void updateUserInfo(UserRequest userRequest);
	
	/**
	 * 新增故事数
	 * @param userId
	 */
	void addStoryCount(String userId);
	
	/**
	 * 新增故事数
	 * @param userId
	 */
	void cutStoryCount(String userId);
}