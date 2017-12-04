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
		
		userMapper.insert(new UserDto("user01", "pass01", RoleEnum.USER));
		userMapper.insert(new UserDto("user02", "pass02", RoleEnum.USER));
		userMapper.insert(new UserDto("user03", "pass03", RoleEnum.ADMIN));

		Assert.assertEquals(3, userMapper.getAll().size());
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		RoleEnum role = RoleEnum.ADMIN;
		UserDto user = new UserDto();
		user.setUserId(101L);
		user.setRole(role);
		
		userMapper.update(user);
		
		UserDto assertUser = userMapper.getOne(101L);
		Assert.assertTrue((role.equals(assertUser.getRole())));
	}
	
	@Test
	public void testFindByUsername() {
		
		UserDto user = userMapper.findByUserName("user01");
		
		Assert.assertNotNull(user);
	}

	@Test
	public void testDelete() throws Exception {
		userMapper.delete(101L);
		
		UserDto assertUser = userMapper.getOne(101L);
		Assert.assertNull(assertUser);
	}
}
