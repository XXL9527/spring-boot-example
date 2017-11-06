package my.example.neo.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import my.example.neo.entity.UserEntity;
import my.example.neo.enums.UserSexEnum;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		
		UserMapper.insert(new UserEntity("テスト０１", "pass01", UserSexEnum.MAN, "ト０１"));
		UserMapper.insert(new UserEntity("テスト０２", "pass02", UserSexEnum.WOMAN, "ト０２"));
		UserMapper.insert(new UserEntity("テスト０３", "pass03", UserSexEnum.OTHERS, "ト０３"));

		Assert.assertEquals(3, UserMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.getAll();
		
		Assert.assertEquals(3, users.size());
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(101L);
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne(101L).getNickName())));
	}

}
