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

import com.its.me.model.AttendanceObj;
import com.its.me.model.ClassObj;
import com.its.me.model.MemberObj;
import com.its.me.model.NoticeObj;
import com.its.me.model.ResResult;
import com.its.me.service.AttendanceService;
import com.its.me.service.ClassService;
import com.its.me.service.LoginUserService;
import com.its.me.service.MemberService;
import com.its.me.service.NoticeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	// eclipse console창에 해당 로그가 찍힌다.

	@Autowired
	private NoticeService NoticeService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/getNotice", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE) // 수신하고자 하는 데이터 포맷을 정의한다.
	public ResResult getNotice(@RequestParam("searchDate1") String searchDate1, 
			@RequestParam("searchDate2") String searchDate2, 
			@RequestParam("searchTitle") String searchTitle, 
			@RequestParam("searchWriter") String searchWriter) {

		List<NoticeObj> Notice = NoticeService.getNotice(searchDate1, searchDate2, searchTitle, searchWriter);

		ResResult rr = new ResResult();

		if (Notice == null ) {
			rr.setCode(500);
			rr.setMsg("공지사항 리스트를 가져 올 수 없습니다.");
			return rr;
		}

		rr.setCode(200);
		rr.setValue(Notice);

		return rr;
	}	
	
	@RequestMapping(value = "/addNotice", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult addNotice(@RequestParam("insertTitle") String insertTitle,
			@RequestParam("insertMsg") String insertMsg) {
		int result = NoticeService.addNotice(insertTitle, insertMsg);
		ResResult rr = new ResResult();
		
		if(result == 999) {
			rr.setCode(500);
			rr.setMsg("공지사항을 추가 할 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		
		return rr;
	}
	
	@RequestMapping(value = "/getContent", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getContent(@RequestParam("searchPnum") String searchPnum) {
		NoticeObj Notice = NoticeService.getContent(searchPnum);

		ResResult rr = new ResResult();

		if (Notice == null ) {
			rr.setCode(500);
			rr.setMsg("공지사항을 가져 올 수 없습니다.");
			return rr;
		}

		rr.setCode(200);
		rr.setValue(Notice);

		return rr;
	}
	
	@RequestMapping(value = "/getView", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getView(@RequestParam("searchPnum") String searchPnum) {
		NoticeObj Notice = NoticeService.getContent(searchPnum);

		ResResult rr = new ResResult();

		if (Notice == null ) {
			rr.setCode(500);
			rr.setMsg("공지사항을 가져 올 수 없습니다.");
			return rr;
		}

		rr.setCode(200);
		rr.setValue(Notice);

		return rr;
	}
	
	@RequestMapping(value = "/updateNotice", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult updateNotice(@RequestParam("insertTitle") String insertTitle,
			@RequestParam("insertMsg") String insertMsg,
			@RequestParam("searchPnum") String searchPnum) {
		int result = NoticeService.updateNotice(insertTitle, insertMsg, searchPnum);
		ResResult rr = new ResResult();
		
		if(result == 999) {
			rr.setCode(500);
			rr.setMsg("공지사항을 추가 할 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		
		return rr;
	}
	
	@RequestMapping(value = "/deleteNotice", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult deleteNotice(@RequestParam("deleteNotice") String deleteNotice) {
		
		int result = NoticeService.deleteNotice(deleteNotice);
		ResResult rr = new ResResult();
		
		if(result == 999) {
			rr.setCode(500);
			rr.setMsg("공지사항을 삭제 할 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		
		return rr;
	}
}
