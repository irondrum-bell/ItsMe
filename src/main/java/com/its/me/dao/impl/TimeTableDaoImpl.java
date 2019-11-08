package com.its.me.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.its.me.dao.TimeTableDao;
import com.its.me.model.AttendanceListAppObj;
import com.its.me.model.CourseObj;
import com.its.me.model.TimeTableObj;


// APP
@Repository("com.its.me.dao.impl.TimeTableDaoImpl")
public class TimeTableDaoImpl extends GenericDaoImpl<TimeTableObj, String> implements TimeTableDao{
	
	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.TimeTableDaoImpl";

	@Override
	public RowMapper<TimeTableObj> getRowMapper() {
		// TODO Auto-generated method stub
		return new RowMapper<TimeTableObj>() {
			@Override
			public TimeTableObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				TimeTableObj timeTableObj = new TimeTableObj();
				timeTableObj.setCname(rs.getString("CNAME"));
				timeTableObj.setLrcode(rs.getString("LRCODE"));
				timeTableObj.setCtime(rs.getString("CTIME"));
				timeTableObj.setProf(rs.getString("PROF"));
				return timeTableObj;
			}
		};
	}


	public RowMapper<CourseObj> getRowMapper2() {
		// TODO Auto-generated method stub
		return new RowMapper<CourseObj>() {
			@Override
			public CourseObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseObj courseObj = new CourseObj();
				courseObj.setCname(rs.getString("CNAME"));
				courseObj.setCcode(rs.getString("CCODE"));
				courseObj.setScr(rs.getString("SCR"));
				courseObj.setLrcode(rs.getString("LRCODE"));
				courseObj.setCtime(rs.getString("CTIME"));
				courseObj.setProf(rs.getString("PROF"));
				return courseObj;
			}
		};
	}
	
	public RowMapper<CourseObj> getRowMapper3() {
		// TODO Auto-generated method stub
		return new RowMapper<CourseObj>() {
			@Override
			public CourseObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseObj courseObj = new CourseObj();
				return courseObj;
			}
		};
	}
	/**
	 * App
	 * 시간표 출력
	 */
	@Override
	public List<TimeTableObj> getTimeTalbe(String userId) {
		
		String sql = getQuery("TableDao.get.Table");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getTimeTable sql : " + sql);
		
		try {
			return jdbcTemplate.query(sql,new Object[] { userId } , getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<TimeTableObj>();
		
	}
	
	/**
	 * App
	 * 수업 출력
	 */
	@Override
	public List<CourseObj> getCourse(String depname) {

		String sql = getQuery("TableDao.get.course");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getCourse sql : " + sql);
		
		try {
			return jdbcTemplate.query(sql,new Object[] { depname } , getRowMapper2());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<CourseObj>();
		
	}

	/**
	 * App
	 * 시간표 등록
	 */
	@Override
	public int insertCourse(String userId, String ccode) {
		String sql = getQuery("TableDao.get.overlap");
		
		System.out.println("overlap sql : " + sql);
		System.out.println(userId+ ccode);
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		try {
			
			if(!(jdbcTemplate.query(sql,new Object[] { userId, ccode }, getRowMapper3()).size()==0)) {
				return 3;
			}
				
			
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		
		sql = getQuery("TableDao.insert.course");
		
		System.out.println("insertCourse sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql,new Object[] { userId, ccode });
		} 
		catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 2;
	}

	/**
	 * App
	 * 시간표 삭제
	 */
	@Override
	public int deleteCourse(String userId, String ccode) {
		String sql = getQuery("TableDao.delete.course");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("insertCourse sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql,new Object[] { userId, ccode });
		} 
		catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 2;
	}

	@Override
	public List<TimeTableObj> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeTableObj get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(TimeTableObj data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(TimeTableObj data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TimeTableObj> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	


}


