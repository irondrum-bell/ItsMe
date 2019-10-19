package com.its.me.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.its.me.dao.LoginUserRoleDao;
import com.its.me.model.LoginUserRole;

//@Repository("roleDao")
@Repository("com.its.me.dao.impl.LoginUserRoleDaoImpl")
public class LoginUserRoleDaoImpl extends GenericDaoImpl<LoginUserRole, Long> implements LoginUserRoleDao {

	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.LoginUserRoleDaoImpl";
	
	public RowMapper<LoginUserRole> getRowMapper() {
		return new RowMapper<LoginUserRole>() {
			@Override
			public LoginUserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
				LoginUserRole role = new LoginUserRole();
				role.setId(rs.getLong("id"));
				role.setName(rs.getString("name"));
				return role;
			}
		};
	}
	@Override
	public List<LoginUserRole> getAll() {
//		String sql = getQuery("roleDao.getAll");
//
//		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		try {
			//return jdbcTemplate.query(sql, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return new ArrayList<LoginUserRole>();
	}

	@Override
	public LoginUserRole get(Long id) {
		
//		String sql = getQuery("roleDao.get.id");
//
//		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		try {
			//return jdbcTemplate.queryForObject(sql, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LoginUserRole get(String roleName){
		
//		String sql = getQuery("roleDao.get.name");
//
//		JdbcTemplate jdbcTemplate = getJdbcTemplate();
//		List<Object> params = new ArrayList<Object>();
//		params.add(roleName);
		try {
			//return jdbcTemplate.queryForObject(sql, params.toArray(), getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean update(LoginUserRole user) {
//		String sql = getQuery("roleDao.update");
//		JdbcTemplate jdbcTemplate = getJdbcTemplate();
//		List<Object> params = new ArrayList<Object>();
//		params.add(user.getId());
//		params.add(user.getName());
		
		try {
			//int result = jdbcTemplate.update(sql, params.toArray());
			
			//if ( result > 0 ) {
			//return true;
		//}
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		//String sql = getQuery("roleDao.delete.id");
		
		//JdbcTemplate jdbcTemplate = getJdbcTemplate();
		//List<Object> params = new ArrayList<Object>();
		//params.add(id);
		
		try {
			//int result = jdbcTemplate.update(sql, params.toArray());
			//if(0 < result) {
			//	return true;
			//}
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean save(LoginUserRole user) {
		//String sql = getQuery("roleDao.save");
		
		//JdbcTemplate jdbcTemplate = getJdbcTemplate();
		//List<Object> params = new ArrayList<Object>();
		
		//params.add(user.getId());
		//params.add(user.getName());
		
		try {
			//int result = jdbcTemplate.update(sql, params.toArray());
			//if(0 < result) {
				//return true;
			//}
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<LoginUserRole> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex) {
		String sql = getQuery("roleDao.search");
/*
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		try {
			return jdbcTemplate.query(sql, new RowMapper<Role>() {
				@Override
				public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
					Role role = new Role();
					role.setId(rs.getLong("id"));
					role.setName(rs.getString("name"));
					return role;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
*/
		return new ArrayList<LoginUserRole>();
	}

	@Override
	public List<LoginUserRole> getUserRoles(Long userId) {

		String sql = getQuery("roleDao.getUserRoles");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();

		try {
			return jdbcTemplate.query(sql, new Object[] { userId }, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return new ArrayList<LoginUserRole>();
	}
}
