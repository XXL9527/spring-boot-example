package com.example.beans;

import java.io.Serializable;

import com.example.enums.RoleEnum;

public class UserDto implements Serializable {

	private static final long serialVersionUID = -1580357560388680252L;

	private Long userId;
	private String userName;
	private String password;
	private RoleEnum role;
	
	public UserDto() {
		super();
	}

	public UserDto(String userName, String password, RoleEnum role) {
		super();
		this.password = password;
		this.userName = userName;
		this.role = role;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleEnum getRole() {
		return role;
	}
	public void setRole(RoleEnum role) {
		this.role = role;
	}
}
