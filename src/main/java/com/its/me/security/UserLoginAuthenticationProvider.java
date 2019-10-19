package com.its.me.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.its.me.model.LoginUser;
import com.its.me.model.LoginUserRole;
import com.its.me.service.LoginUserService;
import com.its.me.util.EncryptionUtil;


public class UserLoginAuthenticationProvider implements AuthenticationProvider{

	
	@Autowired
	private LoginUserService userService;
	
	public UserLoginAuthenticationProvider() {
		System.out.println("UserLoginAuthencationProvider.constructor");
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
        Object principal = authentication.getPrincipal();
        Object password = authentication.getCredentials();
        
        // 해당 ID가 있는지 확인 한다.
        LoginUser userExist = userService.get((String)principal);
        if(userExist == null){
        	throw new BadCredentialsException("id does not exist : " + principal);
        }
        //userExist.setPassword(EncryptionUtil.encrypt(userExist.getPassword()));
        
        // 패스워드가 맞는지 확인한다.
        LoginUser user = userService.get((String)principal, EncryptionUtil.encrypt((String)password));
        //LoginUser user = userService.get((String)principal, (String)password);
        if(user == null) {
			throw new BadCredentialsException("password is invaild");
		}
		
//		String userPassWd = userDaoImpl.getPassWd(username);
//		
//		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
//		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//		UserDetails user = new User(username, userPassWd, roles);

		
		//List<LoginUserRole> roleList = userService.getRoles(user.getUserId());
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		//roles.add(new SimpleGrantedAuthority(user.getRole()));
		//for(LoginUserRole role : roleList) {
			roles.add(new SimpleGrantedAuthority(String.valueOf(user.getRole())));
		//}
		
		
		return new UsernamePasswordAuthenticationToken(principal, password, roles);
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return Authentication.class.isAssignableFrom(authentication);
	}
}
