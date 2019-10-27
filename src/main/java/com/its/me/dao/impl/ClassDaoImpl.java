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
import com.its.me.dao.MemberDao;
import com.its.me.model.ClassObj;
import com.its.me.model.MemberObj;

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



	public List<ClassObj> getClassList(){
		
		String sql = getQuery("classDao.get.classList");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getClassList sql : " + sql);
		
		try {
			return jdbcTemplate.query(sql, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<ClassObj>();
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
