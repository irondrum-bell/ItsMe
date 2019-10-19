package com.its.me;

import java.util.Collection;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		ModelAndView view = null;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String userId = auth.getName();
		String isAdmin = "false";
		
		if(auth == null || !UsernamePasswordAuthenticationToken.class.isAssignableFrom(auth.getClass())){
			view = new ModelAndView("login");
			view.addObject("message", "환영합니다.");

			return view;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		if( authorities.size() < 1) {
			view = new ModelAndView("login");
			return view;
		}

		for(GrantedAuthority authority : auth.getAuthorities()){
			if( "ROLE_ANONYMOUS".equalsIgnoreCase(authority.getAuthority())) {
				view = new ModelAndView("login");
				view.addObject("message", "ID와 패스워드를 확인 하시기 바랍니다.");
				return view;
			}else if( "ROLE_ADMIN".equalsIgnoreCase(authority.getAuthority()) ){
				isAdmin = "true";
			}else {
				System.out.println("authority: " + authority.getAuthority());
			}
		}

		// 등록된 사용자 처리
		view = new ModelAndView("home");
		view.addObject("userId", userId);
		view.addObject("isAdmin", isAdmin);
		return view;
	}
	
}
