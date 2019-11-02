package com.its.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.AttendanceAppDao;
import com.its.me.dao.AttendanceDao;
import com.its.me.model.AttendanceAppObj;
import com.its.me.model.AttendanceObj;


@Service("AttendanceAppService")
public class AttendanceAppService {
	
	@Autowired
	@Qualifier("com.its.me.dao.impl.AttendanceAppDaoImpl")
	private AttendanceAppDao AttendanceAppDao;

	/**
	 * 모든 사용자 정보를 제공한다.
	 * @return 사용자 목록
	 */
	public List<AttendanceAppObj> getAttendance(String userId) {
		List<AttendanceAppObj> AttendanceList = AttendanceAppDao.getAttendanceList(userId);
		return AttendanceList;
	}
	
}
