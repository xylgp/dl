/**
  * <preS>
  * 系统缩写：user
  * 系统名称：user
  * 组件名称：用户管理
  * 文件名称：UserAttentionDao.java
  * 作    者：刘广平
  * 创建日期：2018-10-18
  * </pre>
  */
package com.dl.common.dao.user;

import java.util.List;

import com.dl.common.dao.base.BaseDao;
import com.dl.common.model.entity.user.User;
import com.dl.common.model.entity.user.UserAttention;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface UserAttentionDao extends BaseDao<UserAttention> {
    
	public void cancelAttention(String userId,String attentionId);
	
	public void deleteAttention(String userId,String attentionId);
	
	public List<User> attentionList(String userId);
	
	public List<User> fansList(String attentionId);
}