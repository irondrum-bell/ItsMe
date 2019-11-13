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
	public List<AttendanceObj> getAttendance(String date1, String date2, String subject, String name, String major) {
		List<AttendanceObj> AttendanceList = AttendanceDao.getAttendanceList(date1, date2, subject, name, major);
		return AttendanceList;
	}

	public AttendanceObj getAttendanceContent(String ccode, String num, String atdate) {
		AttendanceObj attendacne= AttendanceDao.getAttendanceContent(ccode, num, atdate);
		return attendacne;
	}

	public int updateAttend(String ccode, String num, String atdate, String ckin, String ckout, String atpre) {
		int result = AttendanceDao.updateAttend(ccode, num, atdate, ckin, ckout, atpre);
		return result;
	}
	
}
