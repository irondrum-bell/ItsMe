package com.its.me.model;

import java.util.List;

//import open.commons.json.annotation.JSONField;
//import open.commons.json.model.DefaultJSONModel;

public class Users/* extends DefaultJSONModel*/{

	//@JSONField(name="users")
	List<LoginUser> users;

	public List<LoginUser> getUsers() {
		return users;
	}

	public void setUsers(List<LoginUser> users) {
		this.users = users;
	} 
}
