package com.te.learnspringsecurity2.configsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

	
	  @Bean public PasswordEncoder getPasswordEmcoder() { return new
	  BCryptPasswordEncoder();
	  
	  }
	 
}
