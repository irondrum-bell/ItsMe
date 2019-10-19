package com.its.me.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.LoginUserDao;
import com.its.me.dao.LoginUserRoleDao;
import com.its.me.model.LoginUser;
import com.its.me.model.LoginUserRole;
import com.its.me.util.UserSortUtil;


@Service("userService")
public class LoginUserService {

	@Autowired
	@Qualifier("com.its.me.dao.impl.LoginUserDaoImpl")
	private LoginUserDao userDao;
	
	@Autowired
	@Qualifier("com.its.me.dao.impl.LoginUserRoleDaoImpl")
	private LoginUserRoleDao roleDao;

	/**
	 * 모든 사용자 정보를 제공한다.
	 * @return 사용자 목록
	 */
	public List<LoginUser> getAll() {
		List<LoginUser> userList = userDao.getAll();
		return userList;
	}
	
	/**
	 * 모든 사용자 수를 반환한다.
	 * @return
	 */
	public int getAllUserCount(){
		int userCount = userDao.getAllUserCount();
		return userCount;
	}
	/**
	 * 
	 * @param page
	 * @return
	 */
	public List<LoginUser> getUserByPage(int page){
		List<LoginUser> userList = userDao.getUserByPage(page);
		return userList;
	}
	
	public LoginUser get(String userid){
		
		LoginUser user = userDao.get(userid);
		
		return user;
	}
	
	public LoginUser get(String userId, String password) {
		LoginUser user = userDao.get(userId);
		
		if(user == null) {
			return null;
		}
		
		if(user.getPassword().equals(password)) {
			return user;
		}
		
		return null;
	}
	

	public List<LoginUser> search(String nameKeyword, String orient, String dir, Long startIndex, Long endIndex) {
		List<LoginUser> userList = userDao.search(nameKeyword, orient, dir, startIndex, endIndex);
		return userList;
	}
	public List<LoginUser> search(LoginUser user) {
		List<LoginUser> userList = userDao.searchUser(user);
		
		Collections.sort(userList, new UserSortUtil());
		
		return userList;
//		List<LoginUser> userList = userDao.searchUser(user);
//		
//		// 권한별 검색 결과
//		List<LoginUser> result = new ArrayList<LoginUser>();
//		
//		// 권한을 넣어준 검색 결과
//		List<LoginUser> resultAll = new ArrayList<LoginUser>();
//		
//		for(LoginUser userPick : userList){
//			List<LoginUserRole> roleList = this.getRoles(userPick.getUserId());
//			// 첫번째 권한의 이름을 넣어준다. 
//			// 첫번째 권한이 제일 높은 권한이기 때문
//			if(!roleList.isEmpty()){
//				userPick.setRole(roleList.get(0).getName());
//			}else{
//				userPick.setRole("no role");
//			}
//			
//			resultAll.add(userPick);
//
//			// 권한별 검색 조건에 검색조건 권한에 따라서 결과로 넣어줌.
//			if(userPick.getRole().equals(user.getRole())){
//				result.add(userPick);
//			}
//		}
//		
//		if(!user.getRole().equals("all")) 
//		{
//			return result;
//		}
//		
//		return resultAll;
		
	}



	public List<LoginUserRole> getRoles() { //권한
		List<LoginUserRole> roleList = roleDao.getAll();
		return roleList;
	}

	public List<LoginUserRole> getRoles(String userId) { //사용자의 권한
		
		LoginUser user = userDao.get(userId);
		if(user == null) {
			return new ArrayList<LoginUserRole>();
		}
		
		List<LoginUserRole> roleList = roleDao.getUserRoles(user.getId());
		//List<LoginUserRole> roleList = null;
		
		return roleList;
	}
	
	public boolean updateUserNRole(LoginUser user, long []roleSet) {
		LoginUser before = userDao.get(user.getUserId());
		
		if(user.getPassword() != null && user.getPassword() != "")
			before.setPassword(user.getPassword());
		
		before.setUserName(user.getUserName());
		before.setMobile(user.getMobile());
		before.setEmail(user.getEmail());
		//before.setOffice(user.getOffice());
		
		//before.setActivate(user.getActivate());
		
//		roleDao.delete(before.getId());
		userDao.updateUserNRole(before, roleSet);
		
//		if(before.getId() == null){
//			return false;
//		}
		return true;
	}
	
	public boolean update (LoginUserRole user){
		
		return roleDao.update(user);
		
	}
	
	public boolean update (LoginUser user) {
						 
		return userDao.update(user);
	}
	
	public boolean save (LoginUser user) {
		return userDao.setUser(user);
//		LoginUserRole role = roleDao.get(LoginUserRole.roleUser);
//		if(role == null){
//			return false;
//		}
//		long []roleSet = new long[]{role.getId()};
//		
//		return userDao.saveUserNRole(user, roleSet);
	}
	
	/**
	 * 아이디 중복 확인
	 * @param userid
	 * @return
	 */
	public boolean checkId (String userid){
		boolean result = false; 
		int count = userDao.getUserCount(userid);
		
		if(count <= 0){
			result = true;
		}
		return result;
	}
	
	
}
