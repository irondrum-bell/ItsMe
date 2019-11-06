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
import com.its.me.model.LoginUser;
import com.its.me.model.Users;
import com.its.me.model.MemberUserInfoObj;

@Repository("com.its.me.dao.impl.LoginUserDaoImpl")
public class LoginUserDaoImpl extends GenericDaoImpl<LoginUser, String> implements LoginUserDao {
	
	public static final String BEAN_QUALIFIER = "com.its.me.dao.impl.LoginUserDaoImpl";
	
	public RowMapper<LoginUser> getRowMapper() {
		return new RowMapper<LoginUser>() {
			@Override
			public LoginUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				LoginUser user = new LoginUser();
				//user.setId(rs.getLong("id"));
				user.setUserId(rs.getString("NUM"));
				user.setPassword(rs.getString("PW"));
				user.setUserName(rs.getString("NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setMobile(rs.getString("PHONE"));
				return user;
			}
		};
	}
	
	
	/**
	 * 모든 사용자 정보 가져오기
	 */
	@Override
	public List<LoginUser> getAll() {

		//String sql = getQuery("userDao.getAll");

		//JdbcTemplate jdbcTemplate = getJdbcTemplate();
		try {
			//return jdbcTemplate.query(sql, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return new ArrayList<LoginUser>();

	}

	/**
	 * 사용자 userId 사용하여 사용자 정보 가져오기
	 */
	@Override
	public LoginUser get(String userId) {
		final String sql = getQuery("userDao.get.userid");
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		// JdbcTemplate : jdbc의 반복적인 코드들을 제거하기 위해 쓰인다. 
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { userId }, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return null;
		/*queryForObject : 한 개의 레코드를 가져온다. 
		1개 이상을 반환할 시 예외처리. 값이 없으면 null을 반환한다. 
		
		queryForList : 한 개이상의 레코드를 가져온다 
		List로 받는다.*/
		
/*		try {
			String userInfo = getUsers();
			Users users = new Users();
			System.out.println("userInfo - " + userInfo);
			users.mature(userInfo);
			
			int usersSize = users.getUsers().size();
			for(int i = 0; i < usersSize; i++){
				if(userId.equals(users.getUsers().get(i).getUserId())){
					return users.getUsers().get(i);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;*/
	}
	
	/**
	 * userId 를 갖는 사용자 수 조회
	 */
	@Override
	public int getUserCount(String userId) {
		
/*		try {
			String userInfo = getUsers();
			Users users = new Users();
			users.mature(userInfo);
			
			int usersSize = users.getUsers().size();
			for(int i = 0; i < usersSize; i++){
				if(userId.equals(users.getUsers().get(i).getUserId())){
					return 1;
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}*/
		
		return 0;
	}
	/**
	 * 모든 사용자 수 조회
	 * @return
	 */
	public int getAllUserCount(){
		//final String sql = getQuery("userDao.getAllUserCount");
		
		//JdbcTemplate jdbcTemplate = getJdbcTemplate();
		try{
			//return jdbcTemplate.queryForInt(sql);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	/**
	 * 사용자 userId와 비밀번호를 사용하여 사용자 정보 가져오기
	 */
	@Override
	public LoginUser get(String userId, String password) {
		
/*		try {
			String userInfo = getUsers();
			Users users = new Users();
			users.mature(userInfo);
			
			int usersSize = users.getUsers().size();
			for(int i = 0; i < usersSize; i++){
				if(userId.equals(users.getUsers().get(i).getUserId())){
					return users.getUsers().get(i);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}*/

		return null;
	}

	/**
	 * 사용자를 저장한다.
	 */
	@Override
	public boolean setUser(LoginUser user) {
//		Users usersTmp = new Users();
//		
//		LoginUser user1 = new LoginUser();
//		LoginUser user2 = new LoginUser();
//		user1.setUserId("admin");
//		user1.setUserName("관리자");
//		user1.setPassword(EncryptionUtil.encrypt("1q2w3e4r5t"));
//		user1.setMobile("010-1234-1234");
//		user1.setEmail("admin@nlpweb.co.kr");
//		user1.setRole("ROLE_ADMIN");
//		user2.setUserId("hjhwang");
//		user2.setUserName("황희정");
//		user2.setPassword(EncryptionUtil.encrypt("1q2w3e4r5t"));
//		user2.setMobile("010-1234-1234");
//		user2.setEmail("hjhwang@nlpweb.co.kr");
//		user2.setRole("ROLE_USER");
//		
//		List<LoginUser> usersTmp2 = new ArrayList<LoginUser>();
//		
//		usersTmp2.add(user1);
//		usersTmp2.add(user2);
//		usersTmp.setUsers(usersTmp2);
		
/*		try {
//			setUsers(usersTmp.toJSONString());
			
			String userInfo = getUsers();
			Users users = new Users();
			users.mature(userInfo);
			
			user.setPassword(EncryptionUtil.encrypt(user.getPassword()));
			
			users.getUsers().add(user);
			
			return setUsers(users.toJSONString());
			
		} catch (JSONException e) {
			e.printStackTrace();
		}*/

		return false;
	}
	
	
	/**
	 * 사용자 정보, 권한 수정
	 */
	@Override
	public boolean updateUserNRole(final LoginUser user, final long []roleSet) {
		
//		final String updateUser = getQuery("userDao.updateUserNRole.updateUser");
//		final String addUserRole = getQuery("userDao.updateUserNRole.addUserRole");
//		final String remUserRole = getQuery("userDao.updateUserNRole.remUserRole");
//
//		JdbcTemplate jdbcTemplate = getJdbcTemplate();
//		
//		boolean result = jdbcTemplate.execute(new ConnectionCallback<Boolean>() {
		boolean result = true;
//			@Override
//			public Boolean doInConnection(Connection con) throws SQLException, DataAccessException {
//				boolean autoCommit = con.getAutoCommit();
//				con.setAutoCommit(false);
//				try {
//					
//					// 사용자 정보를 수정한다.
//					PreparedStatement updateUserStmt = con.prepareStatement(updateUser);
//
//					updateUserStmt.setString(1, user.getUserId());
//					updateUserStmt.setString(2, user.getPassword());
//					updateUserStmt.setString(3, user.getUserName());
//					updateUserStmt.setString(4, user.getEmail());
//					updateUserStmt.setString(5, user.getMobile());
//					updateUserStmt.setString(6, user.getOffice());
//					updateUserStmt.setLong(7, user.getActivate());
//					updateUserStmt.setLong(8, user.getId());
//
//					updateUserStmt.execute();
//					updateUserStmt.close();
//
//					// 사용자에 할당된 role 을 제거한다.
//					PreparedStatement remUserRoleStmt = con.prepareStatement(remUserRole);
//					remUserRoleStmt.setLong(1, user.getId());
//					remUserRoleStmt.execute();
//					remUserRoleStmt.close();
//
//					// 사용자에 롤을 적용한다.
//					if(roleSet != null){
//						PreparedStatement addUserRoleStmt = con.prepareStatement(addUserRole);
//						for(int index = 0; index < roleSet.length; index += 1) {
//							addUserRoleStmt.setLong(1,  user.getId());
//							addUserRoleStmt.setLong(2,  roleSet[index]);
//							addUserRoleStmt.addBatch();
//						}
//						int []results = addUserRoleStmt.executeBatch();
//						addUserRoleStmt.close();
//						
//	
//						for(int r : results) {
//							if(r <= 0) {
//								con.rollback();
//								return false;
//							}
//						}
//					
//					}
//					con.commit();
//
//					return true;
//				} catch (SQLException e) {
//					e.printStackTrace();
//					con.rollback();
//				} finally {
//					con.setAutoCommit(autoCommit);
//				}
//				
//				return false;
//		}
//		});
		
		return result;
	}
	
	/**
	 * 사용자 정보 수정 (권한 제외)
	 */
	@Override
	public boolean update(LoginUser user) {
/*		try {
			String userInfo = getUsers();
			Users users = new Users();
			users.mature(userInfo);
			
			int usersSize = users.getUsers().size();
			for(int i = 0; i < usersSize; i++){
				if(user.getUserId().equals(users.getUsers().get(i).getUserId())){
					
					if(!user.getPassword().equals("")){
						users.getUsers().get(i).setPassword(EncryptionUtil.encrypt(user.getPassword()));
					}
					users.getUsers().get(i).setEmail(user.getEmail());
					users.getUsers().get(i).setMobile(user.getMobile());
					
					return setUsers(users.toJSONString());
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}*/


		return false;

	}

	@Override
	public boolean delete(String id) {
//		String sql = getQuery("userDao.delete");
//
//		JdbcTemplate jdbcTemplate = getJdbcTemplate();
//		List<Object> params = new ArrayList<Object>();
//		params.add(id);
//		try {
//			int result = jdbcTemplate.update(sql, params.toArray());
//			
//			if ( result >= 0 ) {
//				return true;
//			}
//			
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		}
		return false;
	}

	@Override
	public boolean save(LoginUser user) {
//		String sql = getQuery("userDao.save");
//		
//		JdbcTemplate jdbcTemplate = getJdbcTemplate();
//		List<Object> params = new ArrayList<Object>();
//		
//		params.add(user.getUserId());
//		params.add(user.getPassword());
//		params.add(user.getUserName());
//		params.add(user.getEmail());
//		params.add(user.getMobile());
//		params.add(user.getOffice());
//		try {
//			int result = jdbcTemplate.update(sql, params.toArray());
//			
//			if ( result > 0 ) {
//			return true;
//		}
//		}catch (DataAccessException e) {
//			e.printStackTrace();
//		}

		return false;
	}
	/**
	 * 사용자 등록
	 */
	@Override
	public boolean saveUserNRole(final LoginUser user, final long []roleSet) {
		
//		final String saveUser = getQuery("userDao.save");
//		final String addUserRole = getQuery("userDao.updateUserNRole.addUserRole");
//		final String getUser = getQuery("userDao.get.userid");
//
//		JdbcTemplate jdbcTemplate = getJdbcTemplate();
//		
//		boolean result = jdbcTemplate.execute(new ConnectionCallback<Boolean>() {
		boolean result = true;
//			@Override
//			public Boolean doInConnection(Connection con) throws SQLException, DataAccessException {
//				boolean autoCommit = con.getAutoCommit();
//				con.setAutoCommit(false);
//				try {
//					
//					// 사용자 정보를 등록한다.
//					PreparedStatement updateUserStmt = con.prepareStatement(saveUser);
//					
//					SimpleDateFormat simpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss", Locale.KOREA );
//					Date currentTime = new Date ( );
//					String joinDate = simpleDateFormat.format ( currentTime );
//					
//					updateUserStmt.setString(1, user.getUserId());
//					updateUserStmt.setString(2, user.getPassword());
//					updateUserStmt.setString(3, user.getUserName());
//					updateUserStmt.setString(4, user.getEmail());
//					updateUserStmt.setString(5, user.getMobile());
//					updateUserStmt.setString(6, user.getOffice());
//					updateUserStmt.setString(7, joinDate);
//
//					updateUserStmt.execute();
//					updateUserStmt.close();
//					
//					PreparedStatement getUserStmt = con.prepareStatement(getUser);
//					getUserStmt.setString(1, user.getUserId());
//					ResultSet rs = getUserStmt.executeQuery();
//					
//					if(rs.next()){
//						user.setId(rs.getLong("id"));
//					}
//					else {
//						getUserStmt.close();
//						con.rollback();
//						return false;
//					}
//					getUserStmt.close();
//					
//					// 사용자에 롤을 적용한다.
//					PreparedStatement addUserRoleStmt = con.prepareStatement(addUserRole);
//					for(int index = 0; index < roleSet.length; index += 1) {
//						addUserRoleStmt.setLong(1,  user.getId());
//						addUserRoleStmt.setLong(2,  roleSet[index]);
//						addUserRoleStmt.addBatch();
//					}
//					int []results = addUserRoleStmt.executeBatch();
//					addUserRoleStmt.close();
//
//					for(int r : results) {
//						if(r <= 0) {
//							con.rollback();
//							return false;
//						}
//					}
//					con.commit();
//
//					return true;
//				} catch (SQLException e) {
//					e.printStackTrace();
//					con.rollback();
//				} finally {
//					con.setAutoCommit(autoCommit);
//				}
//				
//				return false;
//		}
//		});
		
		return result;
	}
	
	@Override
	public List<LoginUser> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex) {
		return null;
	}
	
	@Override
	public List<LoginUser> searchUser(LoginUser user) {
		
		List<LoginUser> resultUserList = new ArrayList<LoginUser>();
		
		//String userInfo = getUsers();
		Users users = new Users();
		/*		try {
			users.mature(userInfo);
			
			int userListCnt = users.getUsers().size();
			
			for(int i = 0; i < userListCnt; i++){
				if(!user.getUserId().equals("")){
					if(!users.getUsers().get(i).getUserId().contains(user.getUserId())){
						continue;
					}
				}
				
				if(!user.getUserName().equals("")){
					if(!users.getUsers().get(i).getUserName().contains(user.getUserName())){
						continue;
					}
				}
				
				if(!user.getEmail().equals("")){
					if(!users.getUsers().get(i).getEmail().contains(user.getEmail())){
						continue;
					}
				}
				
				if(!user.getMobile().equals("")){
					if(!users.getUsers().get(i).getMobile().contains(user.getMobile())){
						continue;
					}
				}
				
				 if(user.getRole().equals("all")){
					 user.setRole("");
				 }
				
				
				if(!user.getRole().equals("")){
					if(!users.getUsers().get(i).getRole().contains(user.getRole())){
						continue;
					}
				}
				
				resultUserList.add(users.getUsers().get(i));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}*/
		return resultUserList;
	}
	
	
	@Override
	public List<LoginUser> getUserByPage(int page) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	public String getUsers(){
		String users = "";
		File inFile = new File(getUserListPath());
		
		if(inFile.exists()){
			try {
				BufferedReader ib = new BufferedReader(new FileReader(inFile));
				//BufferedReader ib = new BufferedReader(new InputStreamReader(new FileInputStream(getUserListPath()),"utf-8"));
				users = ib.readLine();
				ib.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public boolean setUsers(String users){
		File inFile = new File(getUserListPath());
		
		if(inFile.exists()){
			try {
				BufferedWriter ib = new BufferedWriter(new FileWriter(inFile));
				//BufferedWriter ib = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getUserListPath()),"utf-8"));
				ib.write(users);
				ib.close();
				return true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}*/
	
}
