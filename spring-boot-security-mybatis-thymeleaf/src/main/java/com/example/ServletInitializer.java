package com.example;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 创建ServletInitializer.java继承SpringBootServletInitializer ，
 * 重写configure()，把启动类SpringBootApp.class注册进去。
 * 外部web应用服务器构建Web Application Context的时候，会把启动类添加进去。
 * 
 * @author Genkin.Sou
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * 
	 */
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootApp.class);
    }
}
