/**
  * <pre>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserChannelService.java
  * 作    者：刘广平
  * 创建日期：2018-8-24
  * </pre>
  */
package com.dl.common.service.user;

import java.util.List;

import com.dl.common.base.BaseService;
import com.dl.common.model.app.req.ChannelResponse;
import com.dl.common.model.entity.user.UserChannel;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface UserChannelService extends BaseService<UserChannel> {
    
	/**
	 * 根据用户id批量删除用户板块
	 * @param userId
	 */
	void batchDeleteByUserId(String userId);
	
	/**
	 * 查询用户板块列表
	 * @param userId
	 * @return
	 */
	List<ChannelResponse> getUserChannelList(String userId);
}