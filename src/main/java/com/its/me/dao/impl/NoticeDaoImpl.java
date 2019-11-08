package com.its.me.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.its.me.dao.NoticeDao;
import com.its.me.model.NoticeObj;

@Repository("com.its.me.dao.impl.NoticeDaoImpl")
public class NoticeDaoImpl extends GenericDaoImpl<NoticeObj, String> implements NoticeDao {
	
	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.NoticeDaoImpl";

	@Override
	public RowMapper<NoticeObj> getRowMapper() {
		// TODO Auto-generated method stub
		return new RowMapper<NoticeObj>() {
			@Override
			public NoticeObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				NoticeObj NoticeObj = new NoticeObj();
				NoticeObj.setPnum(rs.getInt("PNUM"));
				NoticeObj.setTitle(rs.getString("TITLE"));
				NoticeObj.setMsg(rs.getString("MSG"));
				NoticeObj.setView(rs.getInt("VIEW"));
				NoticeObj.setWdate(rs.getString("WDATE"));
				NoticeObj.setWrt(rs.getString("WRT"));
		
	
				return NoticeObj;
			}
		};
	}

	@Override
	public List<NoticeObj> getNoticeList(String date1, String date2, String title, String writer){
		
		String sql = getQuery("NoticeDao.get.Notice");

		if(!date1.equals("") && !date2.equals("")) {
			sql+= " " + getQuery("NoticeDao.get.Notice.date");
		}
		if(!title.equals("")) {
			sql+= " " + getQuery("NoticeDao.get.Notice.title");
		}
		if(!writer.equals("")) {
			sql+= " " + getQuery("NoticeDao.get.Notice.writer");
		}
		sql += " " + getQuery("NoticeDao.get.Notice.orderby");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("getNoticeList sql : " + sql);
		
		try {
			if(date1.equals("") && title.equals("") && writer.equals("")) {
				return jdbcTemplate.query(sql, getRowMapper());
			}
			else if(!date1.equals("") && title.equals("") && writer.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {date1, date2}, getRowMapper());
			}
			else if(date1.equals("") && !title.equals("") && writer.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {title}, getRowMapper());
			}
			else if(date1.equals("") && title.equals("") && !writer.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {writer}, getRowMapper());
			}
			else if(!date1.equals("") && !title.equals("") && writer.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {date1, date2, title}, getRowMapper());
			}
			else if(!date1.equals("") && title.equals("") && !writer.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {date1, date2, writer}, getRowMapper());
			}
			else if(date1.equals("") && !title.equals("") && !writer.equals("")) {
				return jdbcTemplate.query(sql, new Object[] {title, writer}, getRowMapper());
			}
			else
				return jdbcTemplate.query(sql, new Object[] {date1, date2, title, writer}, getRowMapper());

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return new ArrayList<NoticeObj>();
	}
	
	@Override
	public int deleteNotice(String deleteNotice) {
		String sql = getQuery("NoticeDao.delete.Notice");
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		System.out.println("deleteNotice sql : " + sql);
		
		try {
			return jdbcTemplate.update(sql, new Object[] {deleteNotice});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 999;
	}
	
	@Override
	public List<NoticeObj> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeObj get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(NoticeObj data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(NoticeObj data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<NoticeObj> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}


