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
import org.springframework.web.bind.annotation.ResponseBody;

import com.its.me.model.LoginUser;
import com.its.me.model.ResResult;
import com.its.me.service.LoginUserService;
import com.its.me.util.EncryptionUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginUserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/sso/login", method = RequestMethod.POST)
	@ResponseBody
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public ResResult login(HttpServletRequest httpServletRequest) {
		
		String id = httpServletRequest.getParameter("id");
		String pwd = httpServletRequest.getParameter("pwd");
		
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
