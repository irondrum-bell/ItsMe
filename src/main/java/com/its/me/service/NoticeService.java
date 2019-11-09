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

	public int addNotice(String title, String msg, String date) {
		int result = NoticeDao.addNotice(title, msg, date);
		return result;
	}

	public NoticeObj getContent(String searchPnum) {
		NoticeObj Notice = NoticeDao.getContent(searchPnum);
		return Notice;
	}

	public int updateNotice(String title, String msg, String pnum) {

		int result = NoticeDao.updateNotice(title, msg, pnum);
		return result;
	}

	/**
	 * 
	 * 공지사항 삭제
	 * @return 삭제 여부 상태
	 * */
	public int deleteNotice(String deleteNotice) {
		int result = NoticeDao.deleteNotice(deleteNotice);
		return result;
	}
	
}
