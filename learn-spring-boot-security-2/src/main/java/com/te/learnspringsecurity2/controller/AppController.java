package com.te.learnspringsecurity2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learnspringsecurity2.entity.dto.LoginDto;
import com.te.learnspringsecurity2.jwt.JwtUtils;
import com.te.learnspringsecurity2.response.GeneralResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class AppController {
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;

	@GetMapping("/test")
	public String testApp() {
		return "App Working";

	}

	@PostMapping(path = "/login")
	public ResponseEntity<GeneralResponse> login(@RequestBody LoginDto loginDto) {

		System.out.println(loginDto.getUsername() + " - " + loginDto.getPassword());
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

		String Token = jwtUtils.generateToken(loginDto.getUsername());
		return ResponseEntity.ok()
				.body(new GeneralResponse(Token, HttpStatus.OK, "message", "error", "login Succesfully"));
	}

	@GetMapping(path = "/admin")
	public ResponseEntity<GeneralResponse> getAdmin() {
		return ResponseEntity.ok().body(new GeneralResponse(null, HttpStatus.OK, "message", "error", "Admin Details"));

	}

	@GetMapping(path = "/mentor")
	public ResponseEntity<GeneralResponse> getMentor() {
		return ResponseEntity.ok().body(new GeneralResponse(null, HttpStatus.OK, "message", "error", "Mentor Details"));

	}

	@GetMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> getEmployee() {
		return ResponseEntity.ok()
				.body(new GeneralResponse(null, HttpStatus.OK, "message", "error", "Employee Details"));

	}

	@PostMapping(path = "/register")
	public ResponseEntity<GeneralResponse> registerEmployee() {
		return ResponseEntity.ok()
				.body(new GeneralResponse(null, HttpStatus.OK, "message", "error", "employee Registered"));
	}

	@PutMapping(path = "/update")
	public ResponseEntity<GeneralResponse> update() {
		return ResponseEntity.ok()
				.body(new GeneralResponse(null, HttpStatus.OK, "message", "error", "employee Updated"));
	}
}
