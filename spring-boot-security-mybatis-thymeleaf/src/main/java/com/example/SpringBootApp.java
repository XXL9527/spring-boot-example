package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://www.thymeleaf.org/doc/articles/layouts.html
@MapperScan("com.example.mapper")
@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootApp.class, args);
	}

}