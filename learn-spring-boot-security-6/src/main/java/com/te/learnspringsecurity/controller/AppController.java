package com.te.learnspringsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learnspringsecurity.jwt.JwtUtils;
import com.te.springbootsecurity.entity.dto.LoginDto;
import com.te.springbootsecurity.response.GeneralResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/c1")
public class AppController {

	private final JwtUtils jwtUtils; 
	
	@GetMapping("/test")
	public String test() {
		return "App Working";
		
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<GeneralResponse> login(@RequestBody LoginDto loginDto){
		String token = jwtUtils.generateToken(loginDto.getUsername());
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, token, "error", "login Successfully"));
	}
}
