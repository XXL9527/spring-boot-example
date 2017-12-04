package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value="/")
    public String home1() {
        return "/home";
    }

    @RequestMapping(value="/home")
    public String home() {
        return "/home";
    }

    @RequestMapping(value="/admin")
    public String admin() {
        return "/admin";
    }

    @RequestMapping(value="/user")
    public String user() {
        return "/user";
    }

    @RequestMapping(value="/about")
    public String about() {
        return "/about";
    }

    @RequestMapping(value="/login")
    public String login() {
        return "/login";
    }

    @RequestMapping(value="/403")
    public String error403() {
        return "/error/error_403";
    }
	
//	@GetMapping("/")
//    public String home1() {
//        return "/home";
//    }
//
//    @GetMapping("/home")
//    public String home() {
//        return "/home";
//    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return "/admin";
//    }
//
//    @GetMapping("/user")
//    public String user() {
//        return "/user";
//    }
//
//    @GetMapping("/about")
//    public String about() {
//        return "/about";
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "/login";
//    }
//
//    @GetMapping("/403")
//    public String error403() {
//        return "/error/403";
//    }

}
