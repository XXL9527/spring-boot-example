package my.example.neo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import my.example.neo.entity.UserEntity;
import my.example.neo.enums.UserSexEnum;
import my.example.neo.provider.UserSqlProvider;

public interface UserMapper {

	@SelectProvider(type=UserSqlProvider.class, method="getAllSql")
	//@Select("SELECT * FROM users")
	@Results({
		@Result(property = "userId",  column = "user_id"),
		@Result(property = "userName",  column = "user_name"),
		@Result(property = "password",  column = "passwd"),
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	List<UserEntity> getAll();
	
	@SelectProvider(type=UserSqlProvider.class, method="getUsersSql")
	@Results({
		@Result(property = "userId",  column = "user_id"),
		@Result(property = "userName",  column = "user_name"),
		@Result(property = "password",  column = "passwd"),
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	List<UserEntity> getList(UserEntity user);
	
	@SelectProvider(type=UserSqlProvider.class, method="getOneSql")
	//@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
		@Result(property = "userId",  column = "user_id"),
		@Result(property = "userName",  column = "user_name"),
		@Result(property = "password",  column = "passwd"),
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	UserEntity getOne(Long id);

	@InsertProvider(type=UserSqlProvider.class, method="insertUserSql")
	//@Insert("INSERT INTO users(userName, passwd, user_sex, nick_name) VALUES(#{userName}, #{password}, #{userSex}, #{nickName})")
	void insert(UserEntity user);

	@UpdateProvider(type=UserSqlProvider.class, method="insertUserSql")
	//@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(UserEntity user);

	@DeleteProvider(type=UserSqlProvider.class, method="insertUserSql")
	//@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);
}
