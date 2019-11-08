package com.its.me.dao;

import java.util.List;

import com.its.me.model.TimeTableObj;
import com.its.me.model.CourseObj;

// APP
public interface TimeTableDao  extends GenericDao<TimeTableObj, String>{

	public List<TimeTableObj> getTimeTalbe(String userId);
	
	public List<CourseObj> getCourse(String depname);
	
	int insertCourse(String userId, String ccode);

	int deleteCourse(String userId, String ccode);
	
}