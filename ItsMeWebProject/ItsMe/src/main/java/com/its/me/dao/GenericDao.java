package com.its.me.dao;
import java.util.List;
import java.util.Locale;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public interface GenericDao<T, K> extends InitializingBean {

	ReloadableResourceBundleMessageSource getQuerySource();

//	JdbcTemplate getJdbcTemplate();

	String getQuery(String name);

	String getQuery(String name, Object[] args, Locale locale);
	
	RowMapper<T> getRowMapper();

	List<T> getAll();

	T get(K id);

	boolean update(T data);
	
	boolean delete(K id);

	boolean save(T data);

	List<T> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex);
	
	
}
