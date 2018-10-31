/**
  * <pre>
  * 系统缩写：story
  * 系统名称：story
  * 组件名称：故事管理
  * 文件名称：CheckRecordServiceImpl.java
  * 作    者：刘广平
  * 创建日期：2018-9-4
  * </pre>
  */
package com.dl.common.service.story.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.base.BaseServiceImpl;
import com.dl.common.model.entity.story.CheckRecord;
import com.dl.common.service.story.CheckRecordService;
import com.dl.common.dao.story.CheckRecordDao;

/**
 * </pre>
 * @描述: 数据访问层基础支撑类.
 * 
 * </pre>
 */
@Repository("checkRecordService")
public class CheckRecordServiceImpl extends BaseServiceImpl<CheckRecord> implements CheckRecordService {
	
	@Autowired
	CheckRecordDao dao;
	
	@Override
	protected BaseDao<CheckRecord> getDao() {
		return dao;
	}

}