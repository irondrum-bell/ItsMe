package com.its.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.AttendanceAppDao;
import com.its.me.dao.AttendanceDao;
import com.its.me.dao.AttendanceListAppDao;
import com.its.me.model.AttendanceAppObj;
import com.its.me.model.AttendanceListAppObj;
import com.its.me.model.AttendanceObj;


@Service("AttendanceListAppService")
public class AttendanceListAppService {
	
	@Autowired
	@Qualifier("com.its.me.dao.impl.AttendanceListAppDaoImpl")
	private AttendanceListAppDao AttendanceAppDao;

	/**
	 * 모든 사용자 정보를 제공한다.
	 * @return 사용자 목록
	 */
	public List<AttendanceListAppObj> getAttendance(String userId, String ccode) {
		List<AttendanceListAppObj> AttendanceList = AttendanceAppDao.getAttendanceList(userId, ccode);
		return AttendanceList;
	}
	
}
