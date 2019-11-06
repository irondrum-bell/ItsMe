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

import com.its.me.model.AttendanceAppObj;
import com.its.me.model.AttendanceListAppObj;
import com.its.me.model.AttendanceObj;
import com.its.me.model.ResResult;
import com.its.me.service.AttendanceListAppService;
import com.its.me.service.AttendanceAppService;
import com.its.me.service.AttendanceService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AttendanceController {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
	//eclipse console창에 해당 로그가 찍힌다. 
	
	@Autowired
	private AttendanceService AttendanceService;
	
	@Autowired
	private AttendanceAppService AttendanceAppService;
	
	@Autowired
	private AttendanceListAppService AttendanceListAppService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/getattendance", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getAttendance( @RequestParam("searchSubject") String searchSubject,
			@RequestParam("searchName") String searchName, 
			@RequestParam(value = "selectMajor", defaultValue = "", required=false) String selectMajor) {
		
		
		List<AttendanceObj> attendance = AttendanceService.getAttendance(searchSubject, searchName, selectMajor);
		
		ResResult rr = new ResResult();
		
		if(attendance == null) {
			rr.setCode(500);
			rr.setMsg("출석 리스트를 가져 올 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		rr.setValue(attendance);
		
		return rr;
	}
	
	/*앱 서비스*/
	@RequestMapping(value = "/getattendanceUser", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getAttendance(@RequestParam("userId") String userId) {
		
		
		List<AttendanceAppObj> attendance = AttendanceAppService.getAttendance(userId);
		
		ResResult rr = new ResResult();
		
		if(attendance == null) {
			rr.setCode(500);
			rr.setMsg("출석 리스트를 가져 올 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		rr.setValue(attendance);
		
		return rr;
	}
	
	@RequestMapping(value = "/getattendanceUserList", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getAttendanceList(@RequestParam("userId") String userId, @RequestParam("ccode") String ccode) {
		
		
		List<AttendanceListAppObj> attendance = AttendanceListAppService.getAttendance(userId,ccode);
		
		ResResult rr = new ResResult();
		
		if(attendance == null) {
			rr.setCode(500);
			rr.setMsg("출석 리스트를 가져 올 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		rr.setValue(attendance);
		
		return rr;
	}
}
