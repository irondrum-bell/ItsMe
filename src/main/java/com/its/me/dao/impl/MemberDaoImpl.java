
package com.its.me.dao.impl;


import java.math.BigInteger;
import java.security.MessageDigest;
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
import com.its.me.model.NoticeObj;

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
				member.setPw(rs.getString("PW"));
				return member;
			}
		};
	}
	
	

	@Override
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

/*	@Override
	public MemberObj isMember(String num) {
		String sql = getQuery("memberDao.get.member");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("isMemberExist sql : " + sql);
		
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {num}, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new MemberObj();
	}	*/
	
	@Override
	public int resetMemberPw(String num, String birth) {
		String sql = getQuery("memberDao.update.userPw");
		
		String _birth = "";
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-512");
		    digest.reset();
		    digest.update(birth.getBytes("utf8"));
		    _birth = String.format("%0128x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("resetMemberPw sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql, new Object[] {_birth, num});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 999;
	}

	@Override
	public int addMember(String belcode, String depcode, String name, String num, String pw, int author, String birth,
			String phone, String email, String addr) {
		String sql = getQuery("memberDao.add.member");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("addMember sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql, new Object[] { num, name, pw, birth, phone, author, belcode, depcode, email, addr});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 999;
	}
	
	@Override
	public MemberObj getMemberContent(String memberNum) {
		String sql = getQuery("memberDao.get.memberList");
		sql += " " + getQuery("memberDao.get.memberList.num");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getMemberContent sql : " + sql);
		
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {memberNum}, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new MemberObj();
	}
	
	@Override
	public int updateMember(String memberBel, String memberDep, String memberName, String memberNum, 
			String memberPw, int memberAuthor, String memberBirth, String memberPhone, 
			String memberEmail, String memberAddr) {
		String sql = getQuery("memberDao.update.member");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("updateMember sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql, new Object[] {memberDep, memberName, memberNum, memberPw,
					memberAuthor, memberBirth, memberPhone, memberEmail, memberAddr, memberNum});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 999;
	}

	@Override
	public int deleteMember(String deleteMember) {
		String sql = getQuery("memberDao.delete.member");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("deleteMember sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql, new Object[] {deleteMember});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 999;
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
}
