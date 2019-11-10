package com.its.me;

import java.util.List;

import javax.ws.rs.Consumes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.its.me.model.ClassObj;
import com.its.me.model.ResResult;
import com.its.me.service.ClassService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ClassController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClassController.class);
	//eclipse console창에 해당 로그가 찍힌다. 
	
	@Autowired
	private ClassService classService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/getClassList", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getClassList(@RequestParam(value = "selectMajor", defaultValue = "", required=false) String selectMajor,
			@RequestParam("searchProName") String searchProName,
			@RequestParam("searchSubject") String searchSubject) {
		
		List<ClassObj> classList = classService.getClassList(selectMajor, searchProName, searchSubject);
		ResResult rr = new ResResult();
		
		if(classList == null) {
			rr.setCode(500);
			rr.setMsg("수업 리스트를 가져 올 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		rr.setValue(classList);
		
		return rr;
	}
	
	@RequestMapping(value = "/getClassContent", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getClassContent(@RequestParam("classCCode") String classCCode) {
		
		ClassObj classObj = classService.getClassContent(classCCode);
		ResResult rr = new ResResult();
		
		if(classObj == null) {
			rr.setCode(500);
			rr.setMsg("강의 정보를 가져올 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		rr.setValue(classObj);
		
		return rr;
	}
	
	@RequestMapping(value = "/addClass", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult addClass(@RequestParam("classDep") String classDep, @RequestParam("classCName") String classCName,
			@RequestParam("classCCode") String classCCode, @RequestParam("classProf") String classProf, 
			@RequestParam("classScore") String classScore, @RequestParam("classCTime") String classCTime, 
			@RequestParam("classRCode") String classRCode) {
		
		
		int result = classService.addClass(classDep, classCName, classCCode, classProf, classScore, classCTime, classRCode);
		ResResult rr = new ResResult();
		
		if(result == 999) {
			rr.setCode(500);
			rr.setMsg("과목을 추가 할 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		
		return rr;
	}
	
	@RequestMapping(value = "/updateClass", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult updateClass(@RequestParam("classDep") String classDep, @RequestParam("classCName") String classCName,
			@RequestParam("classCCode") String classCCode, @RequestParam("classProf") String classProf, 
			@RequestParam("classScore") String classScore, @RequestParam("classCTime") String classCTime, 
			@RequestParam("classRCode") String classRCode) {
		
		
		int result = classService.updateClass(classDep, classCName, classCCode, classProf, classScore, classCTime, classRCode);
		ResResult rr = new ResResult();
		
		if(result == 999) {
			rr.setCode(500);
			rr.setMsg("과목을 수정 할 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		
		return rr;
	}
	
	@RequestMapping(value = "/deleteClass", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult deleteClass(@RequestParam("deleteClass") String deleteClass) {
		
		
		int result = classService.deleteClass(deleteClass);
		ResResult rr = new ResResult();
		
		if(result == 999) {
			rr.setCode(500);
			rr.setMsg("과목을 삭제 할 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		
		return rr;
	}
	
}
