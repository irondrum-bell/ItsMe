package com.its.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.NoticeDao;

import com.its.me.model.NoticeObj;


@Service("NoticeService")
public class NoticeService {
	
	@Autowired
	@Qualifier("com.its.me.dao.impl.NoticeDaoImpl")
	private NoticeDao NoticeDao;

	/**
	 * 모든 사용자 정보를 제공한다.
	 * @return 사용자 목록
	 */
	public List<NoticeObj> getNotice(String date1, String date2, String title, String writer ) {
		List<NoticeObj> NoticeList = NoticeDao.getNoticeList(date1, date2, title, writer);
		return NoticeList;
	}
	
}
