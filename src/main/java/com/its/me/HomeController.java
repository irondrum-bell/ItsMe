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
		
		//spring context holder를 이용하는 방법. Authentication : 인증.
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String userId = auth.getName();
		String isAdmin = "false";
		
		/*UsernamePasswordAuthenticationToken : request로 들어온 username과 password에 해당하는 파라미터의 정보를 담는 곳. */
		if(auth == null || !UsernamePasswordAuthenticationToken.class.isAssignableFrom(auth.getClass())){
			/*auth가 null값이면 isAssignableFrom은 exception을 throw한다.
			 * 런타임에 동적으로 확인할 때 사용한다.  */
			view = new ModelAndView("login");
			view.addObject("message", "환영합니다."); //뷰로 보낼 데이터의 값.

			return view;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();//계정이 가지고 있는 권한 목록을 리턴.		
		if( authorities.size() < 1) {
			view = new ModelAndView("login");
			return view;
		}
		//auth.getAuthorities()에서 차례대로 객체를 꺼내서 authority에다가 넣겠다는 뜻. 
		for(GrantedAuthority authority : auth.getAuthorities()){
			//"ROLE_ANONYMOUS" : 로그인 하지 않아도 접근이 가능한 권한. 
			if( "ROLE_ANONYMOUS".equalsIgnoreCase(authority.getAuthority())) {
				//equalsIgnoreCase : 대소문자와 관련없이 equals 검사.
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








