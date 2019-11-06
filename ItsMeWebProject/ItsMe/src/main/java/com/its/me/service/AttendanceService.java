package com.its.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.AttendanceDao;
import com.its.me.model.AttendanceObj;


@Service("AttendanceService")
public class AttendanceService {
	
	@Autowired
	@Qualifier("com.its.me.dao.impl.AttendanceDaoImpl")
	private AttendanceDao AttendanceDao;

	/**
	 * 모든 사용자 정보를 제공한다.
	 * @return 사용자 목록
	 */
	public List<AttendanceObj> getAttendance(String subject, String name, String major) {
		List<AttendanceObj> AttendanceList = AttendanceDao.getAttendanceList(subject, name, major);
		return AttendanceList;
	}
	
}
