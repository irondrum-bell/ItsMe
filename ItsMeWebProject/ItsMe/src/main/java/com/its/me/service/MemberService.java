package com.its.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.MemberDao;
import com.its.me.model.MemberObj;


@Service("memberService")
public class MemberService {
	
	@Autowired
	@Qualifier("com.its.me.dao.impl.MemberDaoImpl")
	private MemberDao memberDao;

	/**
	 * 모든 사용자 정보를 제공한다.
	 * @return 사용자 목록
	 */
	public List<MemberObj> getMemberList() {
		List<MemberObj> memberList = memberDao.getMemberList();
		return memberList;
	}
	
}
