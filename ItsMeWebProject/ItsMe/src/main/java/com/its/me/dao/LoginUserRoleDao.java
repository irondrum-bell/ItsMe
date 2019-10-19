package com.its.me.dao;

import java.util.List;

import com.its.me.model.LoginUserRole;

public interface LoginUserRoleDao  extends GenericDao<LoginUserRole, Long>{

	List<LoginUserRole> getUserRoles(Long userId);
	LoginUserRole get(String roleName);
}