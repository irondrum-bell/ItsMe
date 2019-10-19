package com.its.me.dao;

import java.util.List;

import com.its.me.model.LoginUser;

public interface LoginUserDao extends GenericDao<LoginUser, String> {

	LoginUser get(String userId);

	LoginUser get(String userId, String password);

	boolean updateUserNRole(LoginUser user, long []roleSet);
	
	boolean saveUserNRole(final LoginUser user, final long []roleSet);
	
	int getUserCount(String userId);
	
	int getAllUserCount();
	
	List<LoginUser> getUserByPage(int page);

	List<LoginUser> searchUser(LoginUser user);
	
	
	boolean setUser(LoginUser user);
}
