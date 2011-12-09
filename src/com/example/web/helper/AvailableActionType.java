package com.example.web.helper;

public enum AvailableActionType {
	VIEW("view"),
	ADD_USER("add_user"),
	ADD_GROUP("add_group"),
	ADD_ROLE("add_role"),
	DELETE_ENTITY("delete_entity"),
	LOGIN("login"),
	LOGIN_ERROR("login_error");
	
	private final String name;
	
	private AvailableActionType(String name){
		this.name= name;
	}

	public String getName() {
		return name;
	}
}
