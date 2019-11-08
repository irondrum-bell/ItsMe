package com.its.me.dao;

import java.util.List;

import com.its.me.model.MemberObj;

public interface MemberDao  extends GenericDao<MemberObj, String>{
	
	public List<MemberObj> getMemberList(String author, String name, String number, String major);

	public int deleteMember(String deleteMember);

}