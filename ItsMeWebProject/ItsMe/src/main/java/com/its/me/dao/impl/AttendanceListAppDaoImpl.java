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
import com.its.me.dao.AttendanceListAppDao;
import com.its.me.model.AttendanceAppObj;
import com.its.me.model.AttendanceListAppObj;

@Repository("com.its.me.dao.impl.AttendanceListAppDaoImpl")
public class AttendanceListAppDaoImpl extends GenericDaoImpl<AttendanceListAppObj, String> implements AttendanceListAppDao{
	
	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.AttendanceAppDaoImpl";

	@Override
	public RowMapper<AttendanceListAppObj> getRowMapper() {
		// TODO Auto-generated method stub
		return new RowMapper<AttendanceListAppObj>() {
			@Override
			public AttendanceListAppObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				AttendanceListAppObj attendanceObj = new AttendanceListAppObj();
				attendanceObj.setAtdate(rs.getString("ATDATE"));
				attendanceObj.setAtpre(rs.getString("ATPRE"));
				attendanceObj.setCcode(rs.getString("CCODE"));
				attendanceObj.setCkin(rs.getString("CKIN"));
				attendanceObj.setCkout(rs.getString("CKOUT"));
				attendanceObj.setDepcode(rs.getString("DEPCODE"));
				attendanceObj.setLrcode(rs.getString("LRCODE"));
				attendanceObj.setNum(rs.getString("NUM"));
				
				return attendanceObj;
			}
		};
	}



	public List<AttendanceListAppObj> getAttendanceList(String userId, String ccode){
		
		String sql = getQuery("AttendanceDao.get.AttendanceList");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getAttendanceList sql : " + sql);
		
		try {
			return jdbcTemplate.query(sql,new Object[] { userId, ccode } , getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<AttendanceListAppObj>();
	}



	@Override
	public List<AttendanceListAppObj> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public AttendanceListAppObj get(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean update(AttendanceListAppObj data) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean save(AttendanceListAppObj data) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public List<AttendanceListAppObj> search(String nameKeyword, String orient, String dir, Long startIndex,
			Long endIndex) {
		// TODO Auto-generated method stub
		return null;
	}




}


