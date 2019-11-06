
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

	public List<MemberObj> getMemberList(String author, String name, String number, String major){
		String sql = getQuery("memberDao.get.memberList");
		
		if(!author.equals("")) {
			sql+= " " + getQuery("memberDao.get.memberList.auth");
		}
		
		if(!name.equals("")) {
			sql+= " " + getQuery("memberDao.get.memberList.name");
		}
		
		if(!number.equals("")) {
			sql+= " " + getQuery("memberDao.get.memberList.number");
		}
		
		if(!major.equals("")) {
			sql+= " " + getQuery("memberDao.get.memberList.major");
		}

		sql += " " + getQuery("memberDao.get.memberList.orderby");

		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getMemberList sql : " + sql);
		System.out.println(author + " "+ major);

		try {
			if(author.equals("") && name.equals("") && number.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, getRowMapper());
			}
			else if(!author.equals("") && name.equals("") && number.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {author}, getRowMapper());
			}
			else if(author.equals("") && !name.equals("") && number.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {name}, getRowMapper());
			}
			else if(author.equals("") && name.equals("") && !number.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {number}, getRowMapper());
			}
			else if(author.equals("") && name.equals("") && number.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {major}, getRowMapper());
			}
			else if(!author.equals("") && !name.equals("") && number.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {author, name}, getRowMapper());
			}
			else if(!author.equals("") && name.equals("") && !number.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {author, number}, getRowMapper());
			}
			else if(!author.equals("") && name.equals("") && number.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {author, major}, getRowMapper());
			}
			else if(author.equals("") && !name.equals("") && !number.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {name, number}, getRowMapper());
			}
			else if(author.equals("") && !name.equals("") && number.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {name, major}, getRowMapper());
			}
			else if(author.equals("") && name.equals("") && !number.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {number, major}, getRowMapper());
			}
			else if(!author.equals("") && !name.equals("") && !number.equals("") && major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {author, name, number}, getRowMapper());
			}
			else if(!author.equals("") && !name.equals("") && number.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {author, name, major}, getRowMapper());
			}
			else if(!author.equals("") && name.equals("") && !number.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {author, number, major}, getRowMapper());
			}
			else if(author.equals("") && !name.equals("") && !number.equals("") && !major.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {name, number, major}, getRowMapper());
			}
			else {
				return jdbcTemplate.query(sql, new Object[] {author, name, number, major}, getRowMapper());
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<MemberObj>();
	}
	
	
}
