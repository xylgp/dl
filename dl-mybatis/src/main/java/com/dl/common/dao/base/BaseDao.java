package com.dl.common.dao.base;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.dl.common.model.page.PageBean;
import com.dl.common.model.page.PageParam;


/**
 * 
 * @描述: 数据访问层基础支撑接口.
 * @作者: luck
 * @创建时间: 2013-7-22,下午4:52:52 .
 * @版本: 1.0 
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 根据实体对象新增记录
	 * @param entity
	 * @return id
	 */
	String insert(T entity);

	/**
	 * 批量保存对象
	 * @param entity
	 * @return id
	 */
	String insert(List<T> list);
	
	/**
	 * 根据ID删除记录
	 * @param id 
	 * @return
	 */
	int deleteById(String id);
	
	/**
	 * 根据ID删除记录.
	 * @param id
	 * @return
	 */
	int deleteByIds(String[] id);

	/**
	 * 更新实体对应的记录
	 * @param entity
	 * @return
	 */
	int update(T entity);

	/**
	 * 批量更新对象
	 * @param entity
	 * @return int
	 */
	int update(List<T> list);

	/**
	 * 根据ID查找记录
	 * @param id
	 * @return entity 
	 */
	T getById(String id);
	
	/**
	 * 多条件查询
	 * @param paramMap
	 * @param sqlId
	 * @return
	 */
	Object getBy(Map<String, Object> paramMap, String sqlId);
	
	/**
	 * 根据条件查询 listBy: <br/>
	 * @param paramMap
	 * @return 返回实体
	 */
	T getBy(Map<String, Object> paramMap);

	/**
	 * 分页查询 
	 * @param pageParam  分页参数
	 * @param paramMap  业务条件查询参数
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

	/**
	 * 自定义查询sql-id，启用PageHelper,只需要编写查询sql，会自动统计分页数据
	 * @param pageParam:分页参数
	 * @param paramMap：查询条件
	 * @param sqlId：查询sql
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId);
	
	/**
	 * 自定义查询sql-id/sqlCount-id，启用PageHelper,只需要编写查询sql，会自动统计分页数据
	 * @param pageParam:分页参数
	 * @param paramMap：查询条件
	 * @param sqlId：查询sql
	 * @param sqlIdCount：统计查询
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId,String sqlIdCount);

	/**
	 * 根据条件查询 listBy: <br/>
	 * @param paramMap
	 * @return 返回集合
	 */
	List<T> listBy(Map<String, Object> paramMap);
	
	/**
	 * 制定SQL条件查询
	 * @param paramMap
	 * @param sqlId
	 * @return
	 */
	List<Object> listBy(Map<String, Object> paramMap, String sqlId);

	/**
	 * 根据序列名称获取下一个值
	 * @return
	 */
	String getSeqNextValue(String seqName);

	SqlSessionTemplate getSessionTemplate();

	SqlSession getSqlSession();
	
	public Object getProxy(Object obj);
}