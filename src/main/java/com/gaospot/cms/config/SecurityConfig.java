package com.gaospot.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gaospot.cms.db.UserRepository;
import com.gaospot.cms.web.UserUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserRepository userRepository;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(new UserUserService(userRepository));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/user/profile").authenticated()
				.antMatchers(HttpMethod.POST, "/news/add").authenticated()
				.anyRequest().permitAll().and()
			.formLogin()
				.defaultSuccessUrl("/news/add")
				.loginPage("/login").and()
			.csrf().disable(); //出于测试目的暂时禁用
			
	}

}
