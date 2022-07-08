/*
 * package com.te.learnspringsecurity.configsecurity;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Component;
 * 
 * @EnableWebSecurity
 * 
 * @Component public class SecurityConfiguration extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Bean public PasswordEncoder getPasswordEncoder() { return new
 * BCryptPasswordEncoder();
 * 
 * }
 * 
 * @Bean
 * 
 * @Override protected AuthenticationManager authenticationManager() throws
 * Exception { return super.authenticationManager(); }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { // TODO Auto-generated method stub super.configure(auth); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable();
 * http.authorizeHttpRequests().antMatchers("/api/employee",
 * "/api/register","/api/login").permitAll().anyRequest().authenticated(); }
 * 
 * }
 */