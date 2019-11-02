package com.its.me.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.its.me.dao.AttendanceAppDao;
import com.its.me.model.AttendanceAppObj;

@Repository("com.its.me.dao.impl.AttendanceAppDaoImpl")
public class AttendanceAppDaoImpl extends GenericDaoImpl<AttendanceAppObj, String> implements AttendanceAppDao{
	
	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.AttendanceAppDaoImpl";

	@Override
	public RowMapper<AttendanceAppObj> getRowMapper() {
		// TODO Auto-generated method stub
		return new RowMapper<AttendanceAppObj>() {
			@Override
			public AttendanceAppObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				AttendanceAppObj attendanceObj = new AttendanceAppObj();
				attendanceObj.setCcode(rs.getString("CCODE"));
				attendanceObj.setCname(rs.getString("CNAME"));
				attendanceObj.setCtime(rs.getString("CTIME"));
				attendanceObj.setProf(rs.getString("PROF"));
				return attendanceObj;
			}
		};
	}



	public List<AttendanceAppObj> getAttendanceList(String userId){
		
		String sql = getQuery("AttendanceDao.get.Attendance");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getAttendanceList sql : " + sql);
		
		try {
			return jdbcTemplate.query(sql,new Object[] { userId } , getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<AttendanceAppObj>();
	}



	@Override
	public List<AttendanceAppObj> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public AttendanceAppObj get(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean update(AttendanceAppObj data) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean save(AttendanceAppObj data) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public List<AttendanceAppObj> search(String nameKeyword, String orient, String dir, Long startIndex,
			Long endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}


