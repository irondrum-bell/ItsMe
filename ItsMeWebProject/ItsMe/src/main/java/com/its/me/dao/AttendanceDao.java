package com.its.me.dao;

import java.util.List;

import com.its.me.model.AttendanceObj;

public interface AttendanceDao  extends GenericDao<AttendanceObj, String>{

	public List<AttendanceObj> getAttendanceList(String subject, String name, String major);
}