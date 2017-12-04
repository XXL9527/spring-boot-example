package com.example.mapper;

import java.util.List;

import com.example.beans.UserDto;

public interface UserMapper {

	List<UserDto> getAll();
	
	UserDto getOne(Long id);
	
	UserDto findByUserName(String userName);

	void insert(UserDto user);

	void update(UserDto user);

	void delete(Long id);
}
