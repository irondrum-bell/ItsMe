package com.its.me;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.its.me.model.ResResult;
import com.its.me.model.TimeTableObj;
import com.its.me.model.CourseObj;
import com.its.me.service.TimeTableService;

/**
 * APP
 */
@Controller
public class TimeTableController {
	
	private static final Logger logger = LoggerFactory.getLogger(TimeTableController.class);
	//eclipse console창에 해당 로그가 찍힌다. 
	
	@Autowired
	private TimeTableService timeTableService;
	
	
	/**
	 * 전체 시간표 테이블 목록 가져오기
	 */
	@RequestMapping(value = "/getTimeTable", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getTimeTable( @RequestParam("userId") String userId) {
		
		
		List<TimeTableObj> timetable = timeTableService.getTimeTable(userId);
		
		ResResult rr = new ResResult();
		
		if(timetable == null) {
			rr.setCode(500);
			rr.setMsg("시간표를 가져 올 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		rr.setValue(timetable);
		
		return rr;
	}
	
	/**
	 * 전체 시간표 테이블 목록 가져오기
	 */
	@RequestMapping(value = "/getCourse", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getCourse( @RequestParam("depname") String depname) {
		
		
		List<CourseObj> timetable = timeTableService.getCourse(depname);
		
		ResResult rr = new ResResult();
		
		if(timetable == null) {
			rr.setCode(500);
			rr.setMsg("시간표를 가져 올 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		rr.setValue(timetable);
		
		return rr;
	}
	
	
	
	/**
	 * APP 
	 * 시간표 등록
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/insertCourse", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult insertCourse( HttpServletRequest httpServletRequest ) {
		
		String userId = httpServletRequest.getParameter("userId");
		String ccode = httpServletRequest.getParameter("ccode");
		
		int insert = timeTableService.insertCourse(userId, ccode);
		
		ResResult rr = new ResResult();
		
		if(insert == 0) {
			rr.setCode(500);
			rr.setMsg("시간표를 추가 할 수 없습니다.");
			return rr;
		}
		else if(insert == 2){
			rr.setCode(400);
			rr.setMsg("오류발생");
			return rr;
		}
		else if(insert == 3) {
			rr.setCode(600);
			rr.setMsg("시간표 중복");
			return rr;
		}
		rr.setCode(200);
		
		return rr;
	}
	
	/**
	 * APP
	 * 시간표 삭제
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult deleteCourse( HttpServletRequest httpServletRequest ) {
		
		String userId = httpServletRequest.getParameter("userId");
		String ccode = httpServletRequest.getParameter("ccode");
		
		int delete = timeTableService.deleteCourse(userId, ccode);
		
		ResResult rr = new ResResult();
		
		if(delete == 0) {
			rr.setCode(500);
			rr.setMsg("시간표를 삭제 할 수 없습니다.");
			return rr;
		}
		else if(delete == 2){
			rr.setCode(400);
			rr.setMsg("오류발생");
			return rr;
		}
		rr.setCode(300);
		
		return rr;
	}
}
