package com.its.me.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

public class CustomJdbcTemplate extends JdbcTemplate {
	
	public CustomJdbcTemplate(DataSource dataSource) {
		super(dataSource);
	}
	
	@Override
	public <T> T queryForObject(String sql, Object[] args, RowMapper<T> rowMapper) throws DataAccessException {
		List<T> results = query(sql, args, new RowMapperResultSetExtractor<T>(rowMapper, 1));
		return results != null && results.size() > 0 ? results.get(0) : null;
	}
}
