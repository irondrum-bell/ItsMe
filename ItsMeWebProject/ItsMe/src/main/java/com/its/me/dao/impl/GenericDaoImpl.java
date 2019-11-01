package com.its.me.dao.impl;

import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.its.me.dao.GenericDao;
import com.its.me.model.NoticeObj;

public abstract class GenericDaoImpl<T, K> implements GenericDao<T, K> {

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	
	private ReloadableResourceBundleMessageSource querySource;

	public GenericDaoImpl() {
	 
	}

	public void afterPropertiesSet() throws Exception {	
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public ReloadableResourceBundleMessageSource getQuerySource() {
		return querySource;
	}
	
	@Autowired
	@Qualifier("querySource")
	public void setQuerySource(ReloadableResourceBundleMessageSource querySource) {
		this.querySource = querySource;
	}

	public JdbcTemplate getJdbcTemplate() {
		if(jdbcTemplate == null) {
			jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate = new CustomJdbcTemplate(dataSource);
		}

		return jdbcTemplate;
	}

	public String getQuery(String name) throws NoSuchMessageException {
		return querySource.getMessage(name, null, null);
	}

	public String getQuery(String name, Object[] args, Locale locale) throws NoSuchMessageException {
		return querySource.getMessage(name, args, locale);
	}

}
