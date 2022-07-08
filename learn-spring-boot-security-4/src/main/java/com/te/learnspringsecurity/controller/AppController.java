package com.te.learnspringsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learnspringsecurity.entity.dto.EmployeeDto;
import com.te.learnspringsecurity.entity.dto.LoginDto;
import com.te.learnspringsecurity.entity.dto.RegisterDto;
import com.te.learnspringsecurity.entity.dto.ShowDeatilsDto;
import com.te.learnspringsecurity.jwt.JwtUtils;
import com.te.learnspringsecurity.response.GeneralResponse;
import com.te.learnspringsecurity.service.AppService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppController {
	
	private final JwtUtils jwtUtils;
	private final AppService appService;

	@GetMapping("/test")
	public ResponseEntity<GeneralResponse> test(){
		
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", "Application Working"));
	}
	
	@PostMapping("/login")
	public ResponseEntity<GeneralResponse> login(@RequestBody LoginDto loginDto){
			String token = jwtUtils.generateToken(loginDto.getUsername());
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, token, "error", " token generated"));
	}
	
	@GetMapping("/employee")
	public ResponseEntity<GeneralResponse> getAllEmployee(){
		
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", "employee"));
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<GeneralResponse> getEmployee(@PathVariable String empId){
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", empId+" employee details "));
	}
	
	@PostMapping("/employee")
	public ResponseEntity<GeneralResponse> saveEmployee(@RequestBody RegisterDto registerDto){
		ShowDeatilsDto register = appService.register(registerDto);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", register));
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<GeneralResponse> deleteEmployee(@PathVariable String empId){
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", empId+" employee details deleted"));
	}
	
	@PutMapping("/employee/{empId}")
	public ResponseEntity<GeneralResponse> updateEmployee(@PathVariable String empId, @RequestBody EmployeeDto employeeDto){
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", empId+" updated employee details "));
	}
	
	
}
