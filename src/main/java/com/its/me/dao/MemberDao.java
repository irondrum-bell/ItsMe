package com.its.me.dao;

import java.util.List;

import com.its.me.model.MemberObj;

public interface MemberDao  extends GenericDao<MemberObj, String>{
	
	public List<MemberObj> getMemberList();

}