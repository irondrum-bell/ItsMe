package com.its.me.dao;

import java.util.List;

import com.its.me.model.ClassObj;

public interface ClassDao  extends GenericDao<ClassObj, String>{

	public List<ClassObj> getClassList(String major, String proname, String subject);

	public ClassObj getClassContent(String ccode);

	public int addClass(String depcode, String cname, String ccode, String prof, String score, String time,
			String lrcode);

	public int updateClass(String depcode, String cname, String ccode, String prof, String score, String time,
			String lrcode);

	public int deleteClass(String ccode);
}