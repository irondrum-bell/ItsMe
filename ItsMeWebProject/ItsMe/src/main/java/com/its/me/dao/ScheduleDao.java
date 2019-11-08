package com.its.me.dao;

import java.util.List;

import com.its.me.model.ScheduleObj;

public interface ScheduleDao extends GenericDao<ScheduleObj, String>{

	public List<ScheduleObj> getScheduleList();

	public int addSchedule(String schedule, String sdate);
}
