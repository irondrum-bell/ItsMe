package com.its.me.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    /**
     * @see org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler#onAuthenticationFailure(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
    	super.onAuthenticationFailure(request, response, exception);
    	
    	//response.sendRedirect("login?error=true");
    	//setDefaultFailureUrl("/login?error=true");
    	//String loginid = request.getParameter("j_username");
    	
        //request.setAttribute("loginid", loginid);
        //request.setAttribute("errormsg", exception.getMessage());
        
        //request.getRequestDispatcher("/login?error=true").forward(request, response);
    }
    
    /**
     * @see org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler#setDefaultFailureUrl(java.lang.String)
     */
    @Override
    public void setDefaultFailureUrl(String defaultFailureUrl) {
        super.setDefaultFailureUrl(defaultFailureUrl);
    }
}