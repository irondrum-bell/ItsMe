
package com.its.me.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.its.me.dao.MemberDao;
import com.its.me.model.MemberObj;

@Repository("com.its.me.dao.impl.MemberDaoImpl")
public class MemberDaoImpl extends GenericDaoImpl<MemberObj, String> implements MemberDao {
	
	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.MemberDaoImpl";

	@Override
	public RowMapper<MemberObj> getRowMapper() {
		// TODO Auto-generated method stub
		return new RowMapper<MemberObj>() {
			@Override
			public MemberObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberObj member = new MemberObj();
				
				member.setNum(rs.getString("NUM"));
				member.setName(rs.getString("NAME"));
				member.setAuth(rs.getInt("AUTH"));
				member.setEmail(rs.getString("EMAIL"));
				member.setPhone(rs.getString("PHONE"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setBelcode(rs.getString("BELCODE"));
				member.setBelname(rs.getString("BELNAME"));
				member.setDepcode(rs.getString("DEPCODE"));
				member.setDepname(rs.getString("DEPNAME"));
				member.setBirth(rs.getString("BIRTH"));
				return member;
			}
		};
	}

	@Override
	public List<MemberObj> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberObj get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(MemberObj data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(MemberObj data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberObj> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MemberObj> getMemberList(){
		
		String sql = getQuery("memberDao.get.memberList");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getMemberList sql : " + sql);
		
		try {
			return jdbcTemplate.query(sql, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<MemberObj>();
	}
	
	
}
