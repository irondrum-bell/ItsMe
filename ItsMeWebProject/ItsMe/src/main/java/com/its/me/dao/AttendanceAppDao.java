package com.its.me.dao;

import java.util.List;

import com.its.me.model.AttendanceAppObj;

public interface AttendanceAppDao  extends GenericDao<AttendanceAppObj, String>{

	public List<AttendanceAppObj> getAttendanceList(String userId);
}