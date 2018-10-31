package com.dl.common.base;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import com.dl.common.dao.base.BaseDao;
import com.dl.common.model.base.BaseEntity;
import com.dl.common.model.base.ResponseData;
import com.dl.common.model.page.PageBean;
import com.dl.common.model.page.PageParam;


/**
 * Service 基类实现
 * 
 * @author luck
 * 
 * @param <T>
 */
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	protected abstract BaseDao<T> getDao();
	
	public ResponseData response = new ResponseData();
	
	@Override
	public String insert(T entity) {
		return getDao().insert(entity);
	}
	
	@Override
	public String insert(List<T> list) {
		return getDao().insert(list);
	}
	
	@Override
	public int update(T entity) {
		return getDao().update(entity);
	}
	
	@Override
	public int update(List<T> list) {
		return getDao().update(list);
	}
	
	@Override
	public T getById(String id) {
		return getDao().getById(id);
	}
	
	@Override
	public long deleteById(String id) {
		return getDao().deleteById(id);
	}
	
	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return getDao().listPage(pageParam, paramMap);
	}
	
	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap,
			String sqlId) {
		return getDao().listPage(pageParam, paramMap, sqlId);
	}
	
	@Override
	public T getBy(Map<String, Object> paramMap) {
		return getDao().getBy(paramMap);
	}
	
	@Override
	public SqlSessionTemplate getSessionTemplate() {
		return getDao().getSessionTemplate();
	}
	
	@Override
	public SqlSession getSqlSession() {
		return getDao().getSqlSession();
	}

}
