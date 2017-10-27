package com.spt.fjj.service.models.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * <p>
 * Description:数据访问层通用父类，实现父类接口ICommonService方法
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company:上海苏翔信息科技有限公司
 * </p>
 * 
 * @author 孫家升
 * @param <T>
 *            类型参数
 */
public abstract class CommonService extends AbstractBaseService implements ICommonService {
	//
	private static Log		log				= LogFactory.getLog(CommonService.class);
	protected JdbcTemplate	jdbcTemplate	= null;
	
	/**
	 * Spring DI
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		try {
			dataSource.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate.setQueryTimeout(100);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.post.poes.models.db.apidao.common.ICommonService#_insert(java.lang.String)
	 */
	@Override
	public int _insert(String sql) throws Exception {
		try {
			log.info("--- 执行插入操作：" + sql);
			int i = this.jdbcTemplate.update(sql);
			log.info("--- [" + sql + "] " + i + " row(s) inserted");
			return i;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.post.poes.models.db.apidao.common.ICommonService#_insert(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int _insert(String sql, Object... args) throws Exception {
		try {
			log.info("--- 执行插入操作：" + sql + " 参数：" + format(args));
			int i = this.jdbcTemplate.update(sql, args);
			log.info("--- [" + sql + "] " + i + " row(s) inserted");
			return i;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.post.poes.models.db.apidao.common.ICommonService#_update(java.lang.String)
	 */
	@Override
	public int _update(String sql) throws Exception {
		try {
			log.info("--- 执行更新操作：" + sql);
			int i = this.jdbcTemplate.update(sql);
			log.info("--- [" + sql + "] " + i + " row(s) updated");
			return i;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.post.poes.models.db.apidao.common.ICommonService#_update(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int _update(String sql, Object... args) throws Exception {
		try {
			log.info("--- 执行更新操作：" + sql + " 参数：" + format(args));
			int i = this.jdbcTemplate.update(sql, args);
			log.info("--- [" + sql + "] " + i + " row(s) updated");
			return i;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.post.poes.models.db.apidao.common.ICommonService#_delete(java.lang.String)
	 */
	@Override
	public int _delete(String sql) throws Exception {
		try {
			log.info("--- 执行删除操作：" + sql);
			int i = this.jdbcTemplate.update(sql);
			log.info("--- [" + sql + "] " + i + " row(s) deleted");
			return i;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.post.poes.models.db.apidao.common.ICommonService#_delete(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int _delete(String sql, Object... args) throws Exception {
		try {
			log.info("--- 执行删除操作：" + sql + " 参数：" + format(args));
			int i = this.jdbcTemplate.update(sql, args);
			log.info("--- [" + sql + "] " + i + " row(s) deleted");
			return i;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.post.poes.models.db.apidao.common.ICommonService#_execBatch(java.lang.String[])
	 */
	@Override
	public int[] _execBatch(String... sql) throws Exception {
		int[] rows = null;
		try {
			log.info("--- 执行批处理操作：" + format((Object[]) sql));
			rows = this.jdbcTemplate.batchUpdate(sql);
			log.info("--- 批处理执行结果：" + format(rows));
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return rows;
	}
	
		
	/*
	 * (non-Javadoc)
	 * @see com.post.poes.models.db.apidao.common.ICommonService#_querySingle(java.lang.String)
	 */
	@Override
	public String _querySingle(String sql) throws Exception {
		String v = null;
		try {
			log.info("--- 执行查询操作：" + sql);
			v = (String) this.jdbcTemplate.queryForObject(sql, java.lang.String.class);
			log.info("--- [" + sql + "] 查询结果为：" + v);
		} catch (Exception e) {
			
			log.error(e);
			throw e;
		}
		return v;
	}
	
	@Override
	public String _querySingle(String sql, Object... args) throws Exception {
		String v = null;
		try {
			log.info("--- 执行查询操作：" + sql);
			v = (String) this.jdbcTemplate.queryForObject(sql,args, java.lang.String.class);
			log.info("--- [" + sql + "] 查询结果为：" + v);
		} catch (Exception e) {
			
			log.error(e);
			throw e;
		}
		return v;
	}
	

	/*
	 * (non-Javadoc)
	 * @see com.post.poes.models.db.apidao.common.ICommonService#_queryMultex(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> _queryMultex(String sql) throws Exception {
		List<Map<String, Object>> ls = null;
		try {
			log.info("--- 执行查询操作：" + sql);
			ls = this.jdbcTemplate.queryForList(sql);
			log.info("--- [" + sql + "] " + (ls != null ? ls.size() : 0) + " row(s) selected");
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return ls;
	}
	
	@Override
	public List<Map<String, Object>> _queryMultex(String sql,Object... args) throws Exception {
		List<Map<String, Object>> ls = null;
		try {
			log.info("--- 执行查询操作：" + sql);
			ls = this.jdbcTemplate.queryForList(sql,args);
			log.info("--- [" + sql + "] " + (ls != null ? ls.size() : 0) + " row(s) selected");
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return ls;
	}
	
	
	
	
	/*
	 * (non-Javadoc)
	 * @see com.post.poes.models.db.apidao.common.ICommonService#_identifyGenerater(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String _identifyGenerater(final String arg0) throws Exception {
		String identify = null;
		try {
			identify = (String) this.jdbcTemplate.execute(new CallableStatementCreator() {
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					String proc = "{call proc_alloc_id(?, ?)}"; // 调用的存储过程
					CallableStatement cs = con.prepareCall(proc);
					cs.setString(1, arg0); // 设置输入参数的值
					cs.registerOutParameter(2, java.sql.Types.VARCHAR); // 注册输出参数的类型
					return cs;
				}
			}, new CallableStatementCallback() {
				public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
					cs.execute();
					return cs.getString(2); // 获取输出参数的值
				}
			});
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return identify;
	}
	

	
	// 格式化输出
	private String format(Object... args) {
		String str = "";
		if (args != null && args.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (Object obj : args) {
				sb.append(obj).append(", ");
			}
			sb.deleteCharAt(sb.length() - 2);
			str = sb.toString();
		}
		return str;
	}
	
	protected boolean touch(int[] rows) {
		if (rows != null && rows.length > 0)
			for (int i : rows) {
				if (i > 0)
					return true;
			}
		return false;
	}
	
	// 格式化输出
	private String format(int[] args) {
		StringBuilder sb = new StringBuilder("[");
		for (int i : args) {
			sb.append(i).append(", ");
		}
		if (sb.length() > 2)
			sb.deleteCharAt(sb.length() - 2);
		sb.append("]");
		return sb.toString();
	}
}
// /:~