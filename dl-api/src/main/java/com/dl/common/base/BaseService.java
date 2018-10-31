package com.dl.common.base;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import com.dl.common.model.base.BaseEntity;
import com.dl.common.model.page.PageBean;
import com.dl.common.model.page.PageParam;


/**
 * 基类Service接口
 * 
 * @author luck
 * 
 * @param <T>
 */
public interface BaseService<T extends BaseEntity> {

	/**
	 * 根据实体对象新增记录.
	 * 
	 * @param entity
	 *            .
	 * @return id .
	 */
	String insert(T entity);
	
	/**
	 * 批量保存对象.
	 * 
	 * @param entity
	 *            .
	 * @return id .
	 */
	String insert(List<T> list);
	
	/**
	 * 根据ID删除记录.
	 * 
	 * @param id
	 *            .
	 * @return
	 */
	long deleteById(String id);

	/**
	 * 更新实体对应的记录.
	 * 
	 * @param entity
	 *            .
	 * @return
	 */
	int update(T entity);

	/**
	 * 批量更新对象.
	 * 
	 * @param entity
	 *            .
	 * @return int .
	 */
	int update(List<T> list);

	/**
	 * 根据ID查找记录.
	 * 
	 * @param id
	 *            .
	 * @return entity .
	 */
	T getById(String id);

	/**
	 * 分页查询 .
	 * 
	 * @param pageParam
	 *            分页参数.
	 * @param paramMap
	 *            业务条件查询参数.
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId);

	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回实体
	 */
	T getBy(Map<String, Object> paramMap);

	SqlSessionTemplate getSessionTemplate();

	SqlSession getSqlSession();

}
