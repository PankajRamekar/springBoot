package com.te.learnspringsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learnspringsecurity.jwt.JwtUtils;
import com.te.learnspringsecurity.response.GeneralResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppController {
	
	private final JwtUtils jwtUtils;

	@GetMapping("/admin/{adminId}")
	public ResponseEntity<GeneralResponse> getAdmin(@PathVariable String adminId) {
		return ResponseEntity.ok().body(new GeneralResponse(null, null, null, null, "Admin"));	
	}
	
	@GetMapping("/login")
	public ResponseEntity<GeneralResponse> login() {
		String token = jwtUtils.generateToken("pankaj");
		return ResponseEntity.ok().body(new GeneralResponse(token, null, null, null, "login Successfully"));
	}
}
