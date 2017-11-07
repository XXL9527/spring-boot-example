package my.example.neo.mapper;

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
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		
		userMapper.insert(new UserEntity("テスト０１", "pass01", UserSexEnum.MAN, "ト０１"));
		userMapper.insert(new UserEntity("テスト０２", "pass02", UserSexEnum.WOMAN, "ト０２"));
		userMapper.insert(new UserEntity("テスト０３", "pass03", UserSexEnum.OTHERS, "ト０３"));

		Assert.assertEquals(3, userMapper.getAll().size());
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		String nickName = "neo";
		UserEntity user = new UserEntity();
		user.setUserId(101L);
		user.setNickName(nickName);
		
		userMapper.update(user);
		
		UserEntity assertUser = userMapper.getOne(101L);
		Assert.assertTrue((nickName.equals(assertUser.getNickName())));
	}

	@Test
	public void testDelete() throws Exception {
		userMapper.delete(101L);
		
		UserEntity assertUser = userMapper.getOne(101L);
		Assert.assertNull(assertUser);
	}
}
