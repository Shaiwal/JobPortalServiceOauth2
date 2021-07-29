package com.spring.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
/*	@Autowired
	UserDetailsService userDetailsService;*/
	
	/*
	 * To override default authorization
	 */
	@Override
	protected
	void configure( HttpSecurity httpSecurity) throws Exception{
		httpSecurity.cors().and().csrf().disable();
		//oauth2login config
		httpSecurity.authorizeRequests()
		.anyRequest().authenticated()
		.and().oauth2Login();
	}
	
	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
		return super.authenticationManager();
    }
}
