package com.its.me.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.its.me.dao.AttendanceDao;
import com.its.me.dao.ClassDao;
import com.its.me.dao.MemberDao;
import com.its.me.model.AttendanceObj;
import com.its.me.model.ClassObj;
import com.its.me.model.MemberObj;

@Repository("com.its.me.dao.impl.AttendanceDaoImpl")
public class AttendanceDaoImpl extends GenericDaoImpl<AttendanceObj, String> implements AttendanceDao {
	
	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.ClassDaoImpl";

	@Override
	public RowMapper<AttendanceObj> getRowMapper() {
		// TODO Auto-generated method stub
		return new RowMapper<AttendanceObj>() {
			@Override
			public AttendanceObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				AttendanceObj attendanceObj = new AttendanceObj();
				attendanceObj.setNum(rs.getString("NUM"));
				attendanceObj.setName(rs.getString("NAME"));
				attendanceObj.setDepname(rs.getString("DEPNAME"));
				attendanceObj.setAtdate(rs.getString("ATDATE"));
				attendanceObj.setAtpre(rs.getString("ATPRE"));
				attendanceObj.setCkin(rs.getString("CKIN"));
				attendanceObj.setCkout(rs.getString("CKOUT"));
				attendanceObj.setCname(rs.getString("CNAME"));
	
				return attendanceObj;
			}
		};
	}



	public List<AttendanceObj> getAttendanceList(){
		
		String sql = getQuery("AttendanceDao.get.AttendanceAll");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getAttendanceList sql : " + sql);
		
		try {
			return jdbcTemplate.query(sql, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<AttendanceObj>();
	}


	@Override
	public List<AttendanceObj> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public AttendanceObj get(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean update(AttendanceObj data) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean save(AttendanceObj data) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public List<AttendanceObj> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}


