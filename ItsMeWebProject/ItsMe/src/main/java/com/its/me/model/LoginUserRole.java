package com.its.me.model;

public class LoginUserRole {
	public static final String roleAdmin = "ROLE_ADMIN";
	public static final String roleUser = "ROLE_USER";
	private Long id;
	private String name;
	
	public LoginUserRole() {
		
	}
	
	public LoginUserRole(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
