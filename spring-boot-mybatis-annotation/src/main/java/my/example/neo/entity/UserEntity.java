package my.example.neo.entity;

import java.io.Serializable;

import my.example.neo.enums.UserSexEnum;

public class UserEntity implements Serializable {

	private static final long serialVersionUID = -1580357560388680252L;

	private Long userId;
	private String userName;
	private String password;
	private UserSexEnum userSex;
	private String nickName;
	
	public UserEntity() {
		super();
	}

	public UserEntity(String userName, String password, UserSexEnum userSex, String nickName) {
		super();
		this.password = password;
		this.userName = userName;
		this.userSex = userSex;
		this.nickName = nickName;
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
	public UserSexEnum getUserSex() {
		return userSex;
	}
	public void setUserSex(UserSexEnum userSex) {
		this.userSex = userSex;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
