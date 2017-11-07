package my.example.neo.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import my.example.neo.entity.UserEntity;


public class UserSqlProvider {

	public String getAllSql() {
		
		return new SQL() {{
		    SELECT("u.user_id, u.user_name, u.passwd, u.user_sex, u.nick_name");
		    FROM("m_user u");
		  	ORDER_BY("u.user_id");
		  }}.toString();
    }
	
	public String getUsersSql(@Param("user") UserEntity user) {
		
		return new SQL() {{
		    SELECT("u.user_id, u.user_name, u.passwd, u.user_sex, u.nick_name");
		    FROM("m_user u");
		    WHERE("0 = 0");
		    if (user.getUserName() != null) {
		    	OR();
		    	WHERE("u.user_name = #{userName}");
		    }
		    if (user.getUserSex() != null) {
		    	OR();
		    	WHERE("u.user_sex = #{userSex}");
		    }
		    if (user.getNickName() != null) {
		    	OR();
		    	WHERE("u.nick_name = #{nickName}");
		    }
		  }}.toString();
	}
	
	public String getOneSql(@Param("id") Long id) {
		
		return new SQL() {{
		    SELECT("u.user_id, u.user_name, u.passwd, u.user_sex, u.nick_name");
		    FROM("m_user u");
		    WHERE("u.user_id = #{id}");
		  }}.toString();
	}
	
	public String insertUserSql() {
		
		return new SQL() {{
		    INSERT_INTO ("m_user");
		    VALUES("user_name", "#{userName}");
		    VALUES("passwd", "#{password}");
		    VALUES("user_sex", "#{userSex}");
		    VALUES("nick_name", "#{nickName}");
		  }}.toString();
	}
	
	public String updateUserSql(@Param("user") UserEntity user) {
		
		return new SQL() {{
		    UPDATE("m_user u");
		    if (user.getUserName() != null) {
		    	SET("u.user_name = #{userName}");
		    }
		    if (user.getPassword() != null) {
		    	SET("u.passwd = #{passwd}");
		    }
		    if (user.getUserSex() != null) {
		    	SET("u.user_sex = #{userSex}");
		    }
		    SET("u.nick_name = #{nickName}");
		    WHERE("u.user_id = #{userId}");
		  }}.toString();
	}
	
	public String deleteUserSql(@Param("id") Long id) {
		
		return new SQL() {{
			DELETE_FROM("m_user");
		    WHERE("user_id = #{id}");
		  }}.toString();
	}
}
