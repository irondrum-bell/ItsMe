package com.its.me;

import java.util.List;

import javax.ws.rs.Consumes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.its.me.model.MemberObj;
import com.its.me.model.ResResult;
import com.its.me.service.LoginUserService;
import com.its.me.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	//eclipse console창에 해당 로그가 찍힌다. 
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/getMemberList", method = RequestMethod.GET)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult getMemberList(@RequestParam("searchName") String searchName) {
		
		
		List<MemberObj> memberList = memberService.getMemberList();
		
		ResResult rr = new ResResult();
		
		if(memberList == null) {
			rr.setCode(500);
			rr.setMsg("회원관리 리스트를 가져 올 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		rr.setValue(memberList);
		
		return rr;
	}	
	
	
	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult addMember(@RequestBody String body) {
		MemberObj memberObj = new MemberObj();
		
		boolean result = memberService.addMember(memberObj);
		
		ResResult rr = new ResResult();
		
		if(result == false) {
			rr.setCode(500);
			rr.setMsg("회원을 등록할 수 없습니다.");
			return rr;
		}
		
		rr.setCode(200);
		rr.setValue(result);
		
		return rr;
	}	
}
