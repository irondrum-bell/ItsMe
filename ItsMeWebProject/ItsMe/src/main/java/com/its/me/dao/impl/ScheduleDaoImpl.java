package com.its.me.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.its.me.dao.ScheduleDao;
import com.its.me.model.ScheduleObj;

@Repository("com.its.me.dao.impl.ScheduleDaoImpl")
public class ScheduleDaoImpl extends GenericDaoImpl<ScheduleObj, String> implements ScheduleDao {

	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.ScheduleDaoImpl";
	
	@Override
	public RowMapper<ScheduleObj> getRowMapper() {
		// TODO Auto-generated method stub
		return new RowMapper<ScheduleObj>() {
			@Override
			public ScheduleObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				ScheduleObj ScheduleObj = new ScheduleObj();
				ScheduleObj.setTitle(rs.getString("title"));
				ScheduleObj.setStart(rs.getString("start"));
	
				return ScheduleObj;
			}
		};
	}

	@Override
	public List<ScheduleObj> getScheduleList(String date1, String date2) {
		// TODO Auto-generated method stub
		String sql = getQuery("ScheduleDao.get.Schedule");
		sql += " " + getQuery("ScheduleDao.get.Schedule.orderby");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getScheduleList sql : " + sql);
		
		try {
			return jdbcTemplate.query(sql, new Object[] {date1, date2}, getRowMapper());

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<ScheduleObj>();
	}

	@Override
	public List<ScheduleObj> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduleObj get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ScheduleObj data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(ScheduleObj data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ScheduleObj> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
