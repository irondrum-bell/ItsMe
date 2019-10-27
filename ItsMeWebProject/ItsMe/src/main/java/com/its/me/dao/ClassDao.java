package com.its.me.dao;

import java.util.List;

import com.its.me.model.ClassObj;

public interface ClassDao  extends GenericDao<ClassObj, String>{

	public List<ClassObj> getClassList();
}