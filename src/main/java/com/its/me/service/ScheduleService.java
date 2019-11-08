package com.its.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.ScheduleDao;
import com.its.me.model.ScheduleObj;

@Service("ScheduleService")
public class ScheduleService {

	@Autowired
	@Qualifier("com.its.me.dao.impl.ScheduleDaoImpl")
	private ScheduleDao ScheduleDao;

	/**
	 * 모든 사용자 정보를 제공한다.
	 * @return 사용자 목록
	 */
	public List<ScheduleObj> getSchedule(String date1, String date2) {
		List<ScheduleObj> ScheduleList = ScheduleDao.getScheduleList(date1, date2);
		return ScheduleList;
	}

	public int addSchedule(String schedule, String sdate) {
		// TODO Auto-generated method stub
		int result = ScheduleDao.addSchedule(schedule, sdate);
		return result;
	}
}
