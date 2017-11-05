package my.example.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.example.neo.entity.UserEntity;
import my.example.neo.mapper.UserMapper;

@RestController
@RequestMapping(value="api")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/v1/getUsers", method=RequestMethod.GET)
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userMapper.getAll();
		return users;
	}
	
    @RequestMapping(value="/v1/getUser/{id}", method=RequestMethod.GET)
    public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping(value="/v1/addUser", method=RequestMethod.POST)
    public void save(@RequestBody UserEntity user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="/v1/updateUser/{id}", method=RequestMethod.PUT)
    public void update(@RequestBody UserEntity user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/v1/deleteUser/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
}
