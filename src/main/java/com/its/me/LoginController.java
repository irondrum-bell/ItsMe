package com.its.me;

import javax.servlet.http.HttpServletRequest;
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

import com.its.me.model.LoginUser;
import com.its.me.model.ResResult;
import com.its.me.model.MemberUserInfoObj;
import com.its.me.service.LoginUserService;
import com.its.me.util.EncryptionUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	//eclipse console창에 해당 로그가 찍힌다. 
	
	@Autowired
	private LoginUserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/sso/login", method = RequestMethod.POST)
	@ResponseBody // : 자바객체를 HTTP 요청의 body내용으로 매핑하는 역할.
	@Consumes(MediaType.APPLICATION_JSON_VALUE)//수신하고자 하는 데이터 포맷을 정의한다. 
	public ResResult login(HttpServletRequest httpServletRequest) {
		
		String id = httpServletRequest.getParameter("id");
		String pwd = httpServletRequest.getParameter("pwd");
		/*httpServletRequest : 클라이언트의 요청과 관련된 정보와 동작을 가지고 있는 객체. 
		- 요청 파라미터 조회.
		- HttpSession 객체 조회 
		- request scope 상의 component간의 데이터 공유 지원*/
		
		LoginUser user = userService.get(id, pwd);
		
		ResResult rr = new ResResult();
		
		if(user == null) {
			rr.setCode(401);
			return rr;
		}
		
		rr.setCode(200);
		return rr;
	}
	
	
	
}
