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
import com.te.springbootsecurity.entity.dto.RegisterDto;
import com.te.springbootsecurity.response.GeneralResponse;
import com.te.springbootsecurity.service.AppService;
import com.te.springbootsecurity.service.implementation.MyServiceImplementation;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppController {

	//private final JwtUtils jwtUtils;
	private final MyServiceImplementation appService;
	

	@GetMapping("/test")
	public ResponseEntity<GeneralResponse> test() {

		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "token", "error", "App Working"));

	}

	@GetMapping("/admin")
	public ResponseEntity<GeneralResponse> getEmployee() {

		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "token", "error", "App Working"));

	}

	@PostMapping("/login")
	public ResponseEntity<GeneralResponse> login(@RequestBody LoginDto loginDto) {
		//String token = jwtUtils.generateToken(loginDto.getUsername());

		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "error", "Login Succesfully"));

	}

	@PostMapping("/register")
	public ResponseEntity<GeneralResponse> saveDetails(@RequestBody RegisterDto registerDto) {
		// ShowDeatilsDto showDeatilsDto = myService.register(registerDto);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "error", "showDeatilsDto"));

	}

}
