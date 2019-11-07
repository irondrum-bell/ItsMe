package com.its.me.dao;

import java.util.List;

import com.its.me.model.AttendanceObj;
import com.its.me.model.NoticeObj;

public interface NoticeDao extends GenericDao<NoticeObj, String>{

	public List<NoticeObj> getNoticeList(String date1, String date2, String title, String writer);
}