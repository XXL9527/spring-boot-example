package com.example.enums;

public enum RoleEnum {
	
	USER("USER"), ADMIN("ADMIN");
	
	private String value;
	
	private RoleEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
