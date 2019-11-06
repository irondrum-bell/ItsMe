package com.its.me.dao;

import com.its.me.model.MemberUserInfoObj;

public interface MemberUserInfoDao extends GenericDao<MemberUserInfoObj, String> {

	MemberUserInfoObj getInfo(String userId);
	
	String editPw(String newPw, String userId);
}
