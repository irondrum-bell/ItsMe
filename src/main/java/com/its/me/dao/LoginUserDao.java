package com.its.me.dao;

import java.util.List;

import com.its.me.model.LoginUser;
import com.its.me.model.MemberUserInfoObj;

public interface LoginUserDao extends GenericDao<LoginUser, String> {

	LoginUser get(String userId);

	LoginUser get(String userId, String password);

	boolean updateUserNRole(LoginUser user, long []roleSet);
	
	boolean saveUserNRole(final LoginUser user, final long []roleSet);
	
	int getUserCount(String userId);
	
	int getAllUserCount();
	
	List<LoginUser> getUserByPage(int page);

	List<LoginUser> searchUser(LoginUser user);
	
	// App 비밀번호 초기화
	String formatPw(String id, String name, String birth, String phone);
	
	boolean setUser(LoginUser user);
}
