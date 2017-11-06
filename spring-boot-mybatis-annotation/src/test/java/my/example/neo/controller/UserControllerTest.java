package my.example.neo.controller;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;  


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import my.example.neo.entity.UserEntity;
import my.example.neo.enums.UserSexEnum;
import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	// 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
    private MockMvc mockMvc;
    
    @Autowired  
    private WebApplicationContext wac;  
    
    @Before
    public void setup(){
		//MockMvcBuilders使用构建MockMvc对象   （项目拦截器有效）
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
    }
    
    @Test
    public void testAddUser() throws Exception {
    	
    	UserEntity user = new UserEntity("テスト０１", "pass01", UserSexEnum.MAN, "ト０１");
    	
    	JSONObject map = JSONObject.fromObject(user);
    	
    	ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addUser").contentType(MediaType.APPLICATION_JSON_UTF8).content(map.toString()));
    	
    	// 模拟向testRest发送get请求    
    	actions.andExpect(status().isOk());
    }
    
    @Test
    public void testUpdateUser() throws Exception {
    	
    	UserEntity user = new UserEntity("pass01", "テスト０１", UserSexEnum.MAN, "ト０１");
    	user.setUserId(101L);
    	
    	JSONObject map = JSONObject.fromObject(user);
        
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/updateUser").contentType(MediaType.APPLICATION_JSON_UTF8).content(map.toString()));
    	
        // 模拟向testRest发送get请求    
    	actions.andExpect(status().isOk());
    	// 预期返回值的媒体类型text/plain;charset=UTF-8
    	actions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)); 
    }
    
    @Test
    public void testGetAllUsers() throws Exception {
    	
    	ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/getAllUsers").contentType(MediaType.APPLICATION_JSON_UTF8));
    	
        // 模拟向testRest发送get请求    
    	actions.andExpect(status().isOk());
    	// 预期返回值的媒体类型text/plain;charset=UTF-8
    	actions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)); 
    	// 返回执行请求的结果    
        MvcResult result = actions.andReturn();
            
        System.out.println(result.getResponse().getContentAsString());  
    }
}
