package com.te.learnspringsecurity.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	//private final SecurityFilter securityFilter;

	@Override

	@Bean
	protected AuthenticationManager authenticationManager() throws Exception { 
		// TODO Auto-generated method stub 
		return super.authenticationManager();
	}

	
	  @Override 
	  protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception {
	  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	  
	  }
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* to permit login without browser */
		http.csrf().disable();
		/* for independancy of client and server changes on each other */
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		/* give permission only for login without any jwt security to all user */
		
		http.authorizeRequests().antMatchers("/api/login", "/api/register", "/api/check").permitAll().anyRequest()
				.authenticated();
		
	}
}
