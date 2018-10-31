package com.dl.common.dao.base;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.druid.pool.DruidDataSource;
import com.dl.common.model.base.BaseEntity;
import com.dl.common.model.exceptions.BizException;
import com.dl.common.model.page.PageBean;
import com.dl.common.model.page.PageParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @描述: 数据访问层基础支撑类.
 * @作者: luck
 * @创建时间: 2013-7-22,下午4:52:52 .
 * @版本: 1.0 .
 * @param <T>
 */
public abstract class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T>{

	protected static final Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);

	public static final String SQL_INSERT = "insert";
	public static final String SQL_BATCH_INSERT = "batchInsert";
	public static final String SQL_UPDATE = "update";
	public static final String SQL_GET_BY_ID = "selectById";
	public static final String SQL_DELETE_BY_ID = "deleteById";
	public static final String SQL_LIST_PAGE = "listPage";
	public static final String SQL_LIST_PAGE_COUNT = "listPageCount";
	public static final String SQL_LIST_BY = "listBy";
	public static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam"; // 根据当前分页参数进行统计

	/**
	 * 注入SqlSessionTemplate实例(要求Spring中进行SqlSessionTemplate的配置).<br/>
	 * 可以调用sessionTemplate完成数据库操作.
	 */
	@Autowired
	public SqlSessionTemplate sessionTemplate;

	@Autowired
	protected SqlSessionFactory sqlSessionFactory;

	@Autowired
	private DruidDataSource druidDataSource;

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }
	
	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public SqlSession getSqlSession() {
		return super.getSqlSession();
	}

	public String insert(T t) {

		if (t == null)
			throw new RuntimeException("T is null");

		int result = sessionTemplate.insert(getStatement(SQL_INSERT), t);

		if (result <= 0)
			throw BizException.DB_INSERT_RESULT_0;

		if (t != null && t.getId() != null && result > 0)
			return t.getId();

		return String.valueOf(result);
	}

	public String insert(List<T> list) {

		if (list == null || list.size() <= 0)
			return "0";

		int result = sessionTemplate.insert(getStatement(SQL_BATCH_INSERT), list);

		if (result <= 0)
			throw BizException.DB_INSERT_RESULT_0;

		return result+"";
	}

	public int update(T t) {
		if (t == null)
			throw new RuntimeException("T is null");

		int result = sessionTemplate.update(getStatement(SQL_UPDATE), t);

		if (result <= 0)
			throw BizException.DB_UPDATE_RESULT_0;

		return result;
	}

	public int update(List<T> list) {

		if (list == null || list.size() <= 0)
			return 0;

		int result = 0;

		for (int i = 0; i < list.size(); i++) {
			this.update(list.get(i));
			result += 1;
		}

		if (result <= 0)
			throw BizException.DB_UPDATE_RESULT_0;

		return result;
	}

	public T getById(String id) {
		return sessionTemplate.selectOne(getStatement(SQL_GET_BY_ID), id);
	}

	public int deleteById(String id) {
		return  sessionTemplate.delete(getStatement(SQL_DELETE_BY_ID), id);
	}
	
	public int deleteByIds(String[] id){
		return  sessionTemplate.delete(getStatement(SQL_DELETE_BY_ID), id);
	}

	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId) {

		if (paramMap == null)
			paramMap = new HashMap<String, Object>();
		// 获取分页数据集 , 注切勿换成 sessionTemplate 对象
		if(pageParam.getPageNum()==0) pageParam.setPageNum(1);
		if(pageParam.getNumPerPage()==0) pageParam.setPageNum(10);
		if(StringUtils.isEmpty(sqlId)) sqlId = SQL_LIST_PAGE;
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage(), true);
		List<Object> list = getSqlSession().selectList(getStatement(sqlId), paramMap);
		if(list.size()==0)
			return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), 0, null);
		PageInfo<Object> pageInfo = new PageInfo<Object>(list);
		return new PageBean(pageInfo.getPageNum(), pageInfo.getPageSize(), (int)pageInfo.getTotal(), list);
	}
	
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId,String sqlIdCount) {

		return listPage(pageParam,paramMap,sqlId) ;
	}

	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return listPage(pageParam,paramMap,SQL_LIST_PAGE) ;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> listBy(Map<String, Object> paramMap) {
		return (List) this.listBy(paramMap, SQL_LIST_BY);
	}

	public List<Object> listBy(Map<String, Object> paramMap, String sqlId) {
		if (paramMap == null)
			paramMap = new HashMap<String, Object>();

		return sessionTemplate.selectList(getStatement(sqlId), paramMap);
	}

	@SuppressWarnings("unchecked")
	public T getBy(Map<String, Object> paramMap) {
		return (T) this.getBy(paramMap, SQL_LIST_BY);
	}

	public Object getBy(Map<String, Object> paramMap, String sqlId) {
		if (paramMap == null || paramMap.isEmpty())
			return null;

		return this.getSqlSession().selectOne(getStatement(sqlId), paramMap);
	}

	public String getStatement(String sqlId) {

		String name = this.getClass().getName();

		StringBuffer sb = new StringBuffer().append(name).append(".").append(sqlId);

		return sb.toString();
	}

	/**
	 * 根据序列名称,获取序列值
	 */
	public String getSeqNextValue(String seqName) {
		boolean isClosedConn = false;
		// 获取当前线程的连接
		Connection connection = this.sessionTemplate.getConnection();
		// 获取Mybatis的SQLRunner类
		SqlRunner sqlRunner = null;
		try {
			// 要执行的SQL
			String sql = "";
			// 数据库驱动类
			String driverClass = druidDataSource.getDriver().getClass().getName();
			// 不同的数据库,拼接SQL语句
			if (driverClass.equals("com.ibm.db2.jcc.DB2Driver")) {
				sql = "  VALUES " + seqName.toUpperCase() + ".NEXTVAL";
			}
			if (driverClass.equals("oracle.jdbc.OracleDriver")) {
				sql = "SELECT " + seqName.toUpperCase() + ".NEXTVAL FROM DUAL";
			}
			if (driverClass.equals("com.mysql.jdbc.Driver")) {
				sql = "SELECT  FUN_SEQ('" + seqName.toUpperCase() + "')";
			}
			// 如果状态为关闭,则需要从新打开一个连接
			if (connection.isClosed()) {
				connection = sqlSessionFactory.openSession().getConnection();
				isClosedConn = true;
			}
			sqlRunner = new SqlRunner(connection);
			Object[] args = {};
			// 执行SQL语句
			Map<String, Object> params = sqlRunner.selectOne(sql, args);
			for (Object o : params.values()) {
				return o.toString();
			}
			return null;
		} catch (Exception e) {
			throw BizException.DB_GET_SEQ_NEXT_VALUE_ERROR.newInstance("获取序列出现错误!序列名称:{%s}", seqName);
		} finally {
			if (isClosedConn) {
				sqlRunner.closeConnection();
			}
		}
	}
	
	public Object getProxy(Object obj){
		return obj;
//		DaoInvocationHandler handler = new DaoInvocationHandler(obj);
//		return Proxy.newProxyInstance(handler.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
	}

}
