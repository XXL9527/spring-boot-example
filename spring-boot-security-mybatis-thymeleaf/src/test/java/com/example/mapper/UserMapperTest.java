package com.example.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.beans.UserDto;
import com.example.enums.RoleEnum;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		
		UserDto user = userMapper.getOne("user01");
		if(user != null) {
			return;
		}
		
		userMapper.insert(new UserDto("user01", "テストユーザ０１", "pass01", RoleEnum.USER));
		userMapper.insert(new UserDto("user02", "テストユーザ０２", "pass02", RoleEnum.USER));
		userMapper.insert(new UserDto("user03", "テストユーザ０３", "pass03", RoleEnum.ADMIN));

		Assert.assertEquals(3, userMapper.getAll().size());
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		RoleEnum role = RoleEnum.ADMIN;
		UserDto user = new UserDto();
		user.setUserId("user01");
		user.setRole(role);
		
		userMapper.update(user);
		
		UserDto assertUser = userMapper.getOne("user01");
		Assert.assertTrue((role.equals(assertUser.getRole())));
	}

	@Test
	public void testDelete() throws Exception {
		userMapper.delete("user01");
		
		UserDto assertUser = userMapper.getOne("user01");
		Assert.assertNull(assertUser);
	}
}
