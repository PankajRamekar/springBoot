package com.te.learnspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.te.springbootsecurity")
public class LearnSpringBootSecurity6Application {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootSecurity6Application.class, args);
	}

}
