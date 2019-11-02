package com.its.me.dao;

import java.util.List;


import com.its.me.model.AttendanceListAppObj;

public interface AttendanceListAppDao  extends GenericDao<AttendanceListAppObj, String>{

	public List<AttendanceListAppObj> getAttendanceList(String userId, String ccode);
}