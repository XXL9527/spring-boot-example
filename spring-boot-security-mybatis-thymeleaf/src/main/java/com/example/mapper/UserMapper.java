package com.example.mapper;

import java.util.List;

import com.example.beans.UserDto;

public interface UserMapper {

	List<UserDto> getAll();
	
	UserDto getOne(String id);

	void insert(UserDto user);

	void update(UserDto user);

	void delete(String id);
}
