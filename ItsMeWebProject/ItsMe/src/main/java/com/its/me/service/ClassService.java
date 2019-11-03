package com.its.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.its.me.dao.ClassDao;
import com.its.me.model.ClassObj;


@Service("classService")
public class ClassService {
	
	@Autowired
	@Qualifier("com.its.me.dao.impl.ClassDaoImpl")
	private ClassDao classDao;

	/**
	 * 모든 사용자 정보를 제공한다.
	 * @return 사용자 목록
	 */
	public List<ClassObj> getClassList(String proname, String subject) {
		List<ClassObj> classList = classDao.getClassList(proname, subject);
		return classList;
	}
	
}
