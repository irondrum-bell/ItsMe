package com.its.me.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.its.me.dao.ClassDao;
import com.its.me.model.ClassObj;

@Repository("com.its.me.dao.impl.ClassDaoImpl")
public class ClassDaoImpl extends GenericDaoImpl<ClassObj, String> implements ClassDao {
	
	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.ClassDaoImpl";

	@Override
	public RowMapper<ClassObj> getRowMapper() {
		// TODO Auto-generated method stub
		return new RowMapper<ClassObj>() {
			@Override
			public ClassObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				ClassObj classObj = new ClassObj();
				classObj.setCcode(rs.getString("CCODE"));
				classObj.setCname(rs.getString("CNAME"));
				classObj.setCtime(rs.getString("CTIME"));
				classObj.setDepcode(rs.getString("DEPCODE"));
				classObj.setLrcode(rs.getString("LRCODE"));
				classObj.setProf(rs.getString("PROF"));
				classObj.setScr(rs.getInt("SCR"));
				classObj.setBelname(rs.getString("BELNAME"));
				classObj.setDepname(rs.getString("DEPNAME"));
				
				return classObj;
			}
		};
	}

	public List<ClassObj> getClassList(String major, String proname, String subject){
		
		String sql = getQuery("classDao.get.classList");
		
		if(!major.equals("")) {
			sql+= " " + getQuery("classDao.get.classList.major");
		}
		
		if(!proname.equals("")) {
			sql+= " " + getQuery("classDao.get.classList.proname");
		}
		
		if(!subject.equals("")) {
			sql+= " " + getQuery("classDao.get.classList.subject");
		}
		
		sql += " " + getQuery("classDao.get.classList.orderby");
	
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getClassList sql : " + sql);
		
		try {
			if(major.equals("") && proname.equals("") && subject.equals("")) {
				return jdbcTemplate.query(sql, getRowMapper());
			}
			else if(!major.equals("") && proname.equals("") && subject.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {major}, getRowMapper());
			}
			else if(major.equals("") && !proname.equals("") && subject.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {proname}, getRowMapper());
			}
			else if(major.equals("") && proname.equals("") && !subject.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {subject}, getRowMapper());
			}
			else if(!major.equals("") && !proname.equals("") && subject.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {major, proname}, getRowMapper());
			}
			else if(!major.equals("") && proname.equals("") && !subject.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {major, subject}, getRowMapper());
			}
			else if(major.equals("") && !proname.equals("") && !subject.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {proname, subject}, getRowMapper());
			}
			else {
				return jdbcTemplate.query(sql, new Object[] {major, proname, subject}, getRowMapper());
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<ClassObj>();
	}

	@Override
	public ClassObj getClassContent(String ccode) {
		String sql = getQuery("classDao.get.classList");
		sql += " " + getQuery("classDao.get.class.ccode");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getClassContent sql : " + sql);
		
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {ccode}, getRowMapper());
		}  catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ClassObj();
	}

	@Override
	public int addClass(String depcode, String cname, String ccode, String prof, String score, String time,
			String lrcode) {
		String sql = getQuery("classDao.add.class");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("addClass sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql, new Object[] {cname, ccode, depcode, lrcode, score, time, prof});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 999;
	}

	@Override
	public int updateClass(String depcode, String cname, String ccode, String prof, String score, String time,
			String lrcode) {
		String sql = getQuery("classDao.update.class");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("updateClass sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql, new Object[] {cname, ccode, depcode, lrcode, score, time, prof, ccode});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 999;
	}

	@Override
	public int deleteClass(String ccode) {
		String sql = getQuery("classDao.delete.class");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("deleteClass sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql, new Object[] {ccode});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 999;
	}

	@Override
	public List<ClassObj> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassObj get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ClassObj data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean save(ClassObj data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ClassObj> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
