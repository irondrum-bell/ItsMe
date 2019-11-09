package com.its.me.dao;

import java.util.List;

import com.its.me.model.MemberObj;

public interface MemberDao  extends GenericDao<MemberObj, String>{
	
	public List<MemberObj> getMemberList(String author, String name, String number, String major);

	public MemberObj isMember(String num);

	public int addMember(String belcode, String depcode, String name, String num, String pw, int author, String birth,
			String phone, String email, String addr);

	public int deleteMember(String deleteMember);

}