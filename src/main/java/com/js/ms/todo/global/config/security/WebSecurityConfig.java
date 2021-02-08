package com.js.ms.todo.global.config.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and();
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/member/**").permitAll()
                .anyRequest().authenticated()
                .and();




    }

}