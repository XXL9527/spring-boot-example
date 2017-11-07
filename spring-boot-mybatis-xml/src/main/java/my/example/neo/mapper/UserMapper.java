package my.example.neo.mapper;

import java.util.List;

import my.example.neo.entity.UserEntity;

public interface UserMapper {

	List<UserEntity> getAll();
	
	List<UserEntity> getList(UserEntity user);
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);
}
