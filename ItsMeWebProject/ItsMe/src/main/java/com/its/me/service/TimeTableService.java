package com.its.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.TimeTableDao;
import com.its.me.model.TimeTableObj;
import com.its.me.model.CourseObj;


// App
@Service("TimeTableService")
public class TimeTableService {
	
	@Autowired
	@Qualifier("com.its.me.dao.impl.TimeTableDaoImpl")
	private TimeTableDao timeTableDao;

	/**
	 * APP
	 * 모든 시간표 정보를 제공한다.
	 * @return 시간표
	 */
	public List<TimeTableObj> getTimeTable(String userId) {
		List<TimeTableObj> TimeTableObjList = timeTableDao.getTimeTalbe(userId);
		return TimeTableObjList;
	}
	/**
	 * APP
	 * 수업 정보를 제공한다.
	 * @return 시간표
	 */
	public List<CourseObj> getCourse(String depname) {
		List<CourseObj> TimeTableObjList = timeTableDao.getCourse(depname);
		return TimeTableObjList;
	}
	
	/**
	 * APP
	 * 시간표 등록
	 * @param userId
	 * @param ccode
	 * @return
	 */
	public int insertCourse(String userId, String ccode) {
		
		return timeTableDao.insertCourse(userId, ccode);
	}
	
	/**
	 * APP
	 * 시간표 삭제
	 * @param userId
	 * @param ccode
	 * @return
	 */
	public int deleteCourse(String userId, String ccode) {
		
		return timeTableDao.deleteCourse(userId, ccode);
	}
	
	
}
