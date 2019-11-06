package com.its.me.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.its.me.dao.LoginUserDao;
import com.its.me.dao.MemberUserInfoDao;
import com.its.me.model.LoginUser;
import com.its.me.model.Users;
import com.its.me.model.MemberUserInfoObj;

/***
 * App 부분
 * @author User
 *
 */
@Repository("com.its.me.dao.impl.LoginUserInfoDaoImpl")
public class MemberUserInfoDaoImpl extends GenericDaoImpl<MemberUserInfoObj, String> implements MemberUserInfoDao {
	
	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.LoginUserInfoDaoImpl";
	
	
	public RowMapper<MemberUserInfoObj> getRowMapper() {
		return new RowMapper<MemberUserInfoObj>() {
			@Override
			public MemberUserInfoObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberUserInfoObj user = new MemberUserInfoObj();
				//user.setId(rs.getLong("id"));
				user.setUserId(rs.getString("NUM"));
				user.setUserName(rs.getString("NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setBirth(rs.getString("BIRTH"));
				user.setMobile(rs.getString("PHONE"));
				user.setAddress(rs.getString("ADDRESS"));
				user.setBelname(rs.getString("BELNAME"));
				user.setDepname(rs.getString("DEPNAME"));
				
				
				return user;
			}
		};
	}
	
	@Override
	public MemberUserInfoObj getInfo(String userId) {
		final String sql = getQuery("userDao.get.userinfo");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		// JdbcTemplate : jdbc의 반복적인 코드들을 제거하기 위해 쓰인다. 
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { userId }, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<MemberUserInfoObj> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean update(MemberUserInfoObj data) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean save(MemberUserInfoObj data) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<MemberUserInfoObj> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberUserInfoObj get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/***
	 * 비밀번호 수정
	 * @return notNull
	 */
	@Override
	public String editPw(String newPw, String userId) {
		final String sql = getQuery("memberDao.update.userPw");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		
		// JdbcTemplate : jdbc의 반복적인 코드들을 제거하기 위해 쓰인다. 
		try {
			return jdbcTemplate.update(sql, new Object[] { newPw, userId }) + "";
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return null;
	}
	
}
