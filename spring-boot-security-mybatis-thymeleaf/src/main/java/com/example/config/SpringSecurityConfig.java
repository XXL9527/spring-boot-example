package com.example.config;

import static com.example.enums.RoleEnum.ADMIN;
import static com.example.enums.RoleEnum.USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    
    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        	.csrf().disable()
            .authorizeRequests()
            .antMatchers("/", "/home", "/about").permitAll()
            .antMatchers("/test/admin/**").hasAnyRole(ADMIN.getValue())
            .antMatchers("/test/user/**").hasAnyRole(USER.getValue())
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/error_403")
            .and()
            .sessionManagement()
            .maximumSessions(1)
            .maxSessionsPreventsLogin(true)
            ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
//        auth.inMemoryAuthentication()
//        	.withUser("user").password("password").roles("USER")
//        	.and()
//        	.withUser("admin").password("password").roles("ADMIN");
    }
    
    //Spring Boot configured this already.
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//            .ignoring()
//            .antMatchers("/resources/**")
//            .antMatchers("/static/**")
//            .antMatchers("/css/**")
//            .antMatchers("/js/**")
//            .antMatchers("/images/**")
//            .antMatchers("/webjars/**")
//            .antMatchers("/**/favicon.ico")
//            .antMatchers("/error")
//            ;
//    }
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("ADMIN");
//    }

}
