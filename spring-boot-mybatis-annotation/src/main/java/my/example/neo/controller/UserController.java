package my.example.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.example.neo.entity.UserEntity;
import my.example.neo.mapper.UserMapper;

@RestController
@RequestMapping(value="api/v1")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/getAllUsers", method=RequestMethod.GET)
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userMapper.getAll();
		return users;
	}
	
	@RequestMapping(value="/getUserList", method=RequestMethod.GET)
    public List<UserEntity> getUsers(@RequestBody UserEntity user) {
    	List<UserEntity> users=userMapper.getList(user);
        return users;
    }
	
    @RequestMapping(value="/getUser", method=RequestMethod.GET)
    public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping(value="/addUser", method=RequestMethod.POST)
    public void save(@RequestBody UserEntity user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="/updateUser", method=RequestMethod.PUT)
    public void update(@RequestBody UserEntity user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/deleteUser", method=RequestMethod.DELETE)
    public void delete(Long id) {
    	userMapper.delete(id);
    }
}
