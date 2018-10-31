/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：ChannelService.java
  * 作    者：刘广平
  * 创建日期：2018-8-23
  * </pre>
  */
package com.dl.common.service.story;

import java.util.List;

import com.dl.common.base.BaseService;
import com.dl.common.model.entity.story.Channel;

/**
 * <pre>
 * @描述:数据访问层接口.
 * 表
 * </pre>	
 */
public interface ChannelService extends BaseService<Channel> {
    
	//获取默认的板块列表
	List<Channel> getDefaultChannelList();
	
	//获取全部的板块列表
	List<Channel> getFullChannelList();
	
	//根据板块编码后去板块消息
	Channel getByChannelCode(String channelCode);
	
	void test(String usedId);
}