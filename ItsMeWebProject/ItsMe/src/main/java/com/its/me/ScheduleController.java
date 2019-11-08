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

import com.its.me.model.ResResult;
import com.its.me.model.ScheduleObj;
import com.its.me.service.ScheduleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ScheduleController {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	// eclipse console창에 해당 로그가 찍힌다.

	@Autowired
	private ScheduleService ScheduleService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/getSchedule", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE) // 수신하고자 하는 데이터 포맷을 정의한다.
	public ResResult getSchedule() {

		List<ScheduleObj> Schedule = ScheduleService.getSchedule();

		ResResult rr = new ResResult();

		if (Schedule == null ) {
			rr.setCode(500);
			rr.setMsg("일정 리스트를 가져 올 수 없습니다.");
			return rr;
		}

		rr.setCode(200);
		rr.setValue(Schedule);

		return rr;
	}
	
	@RequestMapping(value = "/addSchedule", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE) // 수신하고자 하는 데이터 포맷을 정의한다.
	public ResResult addSchedule(@RequestParam("insertTitle") String insertTitle,
			@RequestParam("insertStart") String insertStart) {

		int result = ScheduleService.addSchedule(insertTitle, insertStart);

		ResResult rr = new ResResult();

		if (result == 999 ) {
			rr.setCode(500);
			rr.setMsg("일정을 추가할 수 없습니다.");
			return rr;
		}

		rr.setCode(200);

		return rr;
	}
}
