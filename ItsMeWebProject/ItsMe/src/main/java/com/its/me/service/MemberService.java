package com.its.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.MemberUserInfoDao;
import com.its.me.dao.MemberDao;
import com.its.me.model.MemberObj;
import com.its.me.model.MemberUserInfoObj;


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
	
	public boolean addMember(MemberObj obj) {
		 
		return memberDao.save(obj);
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


