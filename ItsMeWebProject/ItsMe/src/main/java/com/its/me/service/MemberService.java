package com.its.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.MemberUserInfoDao;
import com.its.me.dao.MemberDao;
import com.its.me.model.MemberObj;
import com.its.me.model.MemberUserInfoObj;
import com.its.me.model.NoticeObj;


@Service("memberService")
public class MemberService {
	
	@Autowired
	@Qualifier("com.its.me.dao.impl.MemberDaoImpl")
	private MemberDao memberDao;
	
	@Autowired
	@Qualifier("com.its.me.dao.impl.LoginUserInfoDaoImpl")
	private MemberUserInfoDao userInfoDao;

	
	/**
	 * 모든 사용자 정보를 제공한다.
	 * @return 사용자 목록
	 */
	public List<MemberObj> getMemberList(String author, String name, String number, String major) {
		List<MemberObj> memberList = memberDao.getMemberList(author, name, number, major);
		return memberList;
	}

	/*public MemberObj isMember(String num) {
		MemberObj member = memberDao.isMember(num);
		return member;
	}*/

	public int resetMemberPw(String num, String birth) {
		int result = memberDao.resetMemberPw(num, birth);
		return result;
	}

	public int addMember(String belcode, String depcode, String name, String num, String pw, int author,
			String birth, String phone, String email, String addr) {
		int result = memberDao.addMember(belcode, depcode, name, num, pw, author, birth, phone, email, addr);
		return result;
	}

	public int addMember(String belcode, String depcode, String name, String num, String pw, int author,
			String birth, String phone, String email, String addr, String imgpath, String originnm, String savenm) {
		int result = memberDao.addMember(belcode, depcode, name, num, pw, author, birth, 
				phone, email, addr, imgpath, originnm, savenm);
		return result;
	}
	
	public MemberObj getMemberContent(String memberNum) {
		MemberObj Member = memberDao.getMemberContent(memberNum);
		return Member;
	}
	
	public int updateMember(String memberBel, String memberDep, String memberName, String memberNum, 
			String memberPw, int memberAuthor, String memberBirth, String memberPhone, 
			String memberEmail, String memberAddr) {

		int result = memberDao.updateMember(memberBel, memberDep, memberName, memberNum, memberPw,
				memberAuthor, memberBirth, memberPhone, memberEmail, memberAddr);
		return result;
	}

	/**
	 * 
	 * 사용자의 정보 삭제
	 * @return 삭제 여부 상태
	 * */
	public int deleteMember(String deleteMember) {
		int result = memberDao.deleteMember(deleteMember);
		return result;
	}
	
	/**
	 * 
	 * 사용자의 정보 제공
	 * @return 사용자 정보
	 * */
	public MemberUserInfoObj getInfo(String userId) {
		MemberUserInfoObj userinfo = userInfoDao.getInfo(userId);
		
		return userinfo;
	}
	
	/**
	 * 비밀번호 수정
	 * @param newPw
	 * @param userId
	 * @return
	 */
	public String editPw(String newPw, String userId) {
		String editPw = userInfoDao.editPw(newPw, userId);

		return editPw;
	}
	
}


