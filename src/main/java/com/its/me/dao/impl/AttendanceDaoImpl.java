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
import com.its.me.model.AttendanceObj;

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
				attendanceObj.setCcode(rs.getString("CCODE"));
	
				return attendanceObj;
			}
		};
	}

	public List<AttendanceObj> getAttendanceList(String date1, String date2, String subject, String name, String major){
		
		String sql = getQuery("AttendanceDao.get.AttendanceAll");
		
		if(!date1.equals("") && !date2.equals("")) {
			sql+= " " + getQuery("AttendanceDao.get.AttendanceAll.date");
		}
		if(!subject.equals("")) {
			sql+= " " + getQuery("AttendanceDao.get.AttendanceAll.subject");
		}
		if(!name.equals("")) {
			sql+= " " + getQuery("AttendanceDao.get.AttendanceAll.name");
		}
		if(!major.equals("")) {
			sql+= " " + getQuery("AttendanceDao.get.AttendanceAll.major");
		}
		sql += " " + getQuery("AttendanceDao.get.AttendanceAll.orderby");

		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getAttendanceList sql : " + sql);
		
		try {
			if(date1.equals("") && subject.equals("") && name.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, getRowMapper());
			}
			else if(!date1.equals("") && subject.equals("") && name.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {date1, date2}, getRowMapper());
			}
			else if(date1.equals("") && !subject.equals("") && name.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {subject}, getRowMapper());
			}
			else if(date1.equals("") && subject.equals("") && !name.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {name}, getRowMapper());
			}
			else if(date1.equals("") && subject.equals("") && name.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {major}, getRowMapper());
			}
			else if(!date1.equals("") && !subject.equals("") && name.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {date1, date2, subject}, getRowMapper());
			}
			else if(!date1.equals("") && subject.equals("") && !name.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {date1, date2, name}, getRowMapper());
			}
			else if(!date1.equals("") && subject.equals("") && name.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {date1, date2, major}, getRowMapper());
			}
			else if(date1.equals("") && !subject.equals("") && !name.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {subject, name}, getRowMapper());
			}
			else if(date1.equals("") && !subject.equals("") && name.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {subject, major}, getRowMapper());
			}
			else if(date1.equals("") && subject.equals("") && !name.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {name, major}, getRowMapper());
			}
			else if(!date1.equals("") && !subject.equals("") && !name.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {date1, date2, subject, name}, getRowMapper());
			}
			else if(!date1.equals("") && !subject.equals("") && name.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {date1, date2, subject, major}, getRowMapper());
			}
			else if(!date1.equals("") && subject.equals("") && !name.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {date1, date2, name, major}, getRowMapper());
			}
			else if(date1.equals("") && !subject.equals("") && !name.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {subject, name, major}, getRowMapper());
			}
			else
				return jdbcTemplate.query(sql, new Object[] {date1, date2, subject, name, major}, getRowMapper());
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<AttendanceObj>();
	}

	@Override
	public AttendanceObj getAttendanceContent(String ccode, String num, String atdate) {
		String sql = getQuery("AttendanceDao.get.AttendanceAll");
		sql += " " + getQuery("AttendanceDao.get.AttendanceAll.ccode");
		sql += " " + getQuery("AttendanceDao.get.AttendanceAll.num");
		sql += " " + getQuery("AttendanceDao.get.AttendanceAll.atdate");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getAttendanceContent sql : " + sql);
		
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {ccode, num, atdate}, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new AttendanceObj();
	}

	@Override
	public int updateAttend(String ccode, String num, String atdate, String ckin, String ckout, String atpre) {
		String sql = getQuery("AttendanceDao.update.Attendance");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("updateAttendance sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql, new Object[] {ckin, ckout, atpre, ccode, num, atdate});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 999;
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


