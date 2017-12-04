package com.example.beans;

import java.io.Serializable;

import com.example.enums.RoleEnum;

import lombok.Data;

@Data
public class UserDto implements Serializable {

	private static final long serialVersionUID = -1580357560388680252L;

	private String userId;
	private String userName;
	private String password;
	private RoleEnum role;
	
	public UserDto() {
		super();
	}

	public UserDto(String userId, String userName, String password, RoleEnum role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
}
