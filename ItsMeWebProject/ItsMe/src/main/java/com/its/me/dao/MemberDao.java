package com.its.me.dao;

import java.util.List;

import com.its.me.model.MemberObj;
import com.its.me.model.NoticeObj;

public interface MemberDao  extends GenericDao<MemberObj, String>{
	
	public List<MemberObj> getMemberList(String author, String name, String number, String major);

	/*public MemberObj isMember(String num);*/

	public int resetMemberPw(String num, String birth);
	
	public MemberObj getMemberContent(String memberNum);

	public int addMember(String belcode, String depcode, String name, String num, String pw, int author, String birth,
			String phone, String email, String addr);
	
	public int updateMember(String memberBel, String memberDep, String memberName, String memberNum, 
			String memberPw, int memberAuthor, String memberBirth, String memberPhone, 
			String memberEmail, String memberAddr);

	public int deleteMember(String deleteMember);

}