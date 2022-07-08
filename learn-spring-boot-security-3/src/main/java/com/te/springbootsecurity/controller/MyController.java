package com.te.springbootsecurity.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootsecurity.entity.Employee;
import com.te.springbootsecurity.entity.dto.LoginDto;
import com.te.springbootsecurity.entity.dto.RegisterDto;
import com.te.springbootsecurity.entity.dto.ShowDeatilsDto;
import com.te.springbootsecurity.response.GeneralResponse;
import com.te.springbootsecurity.service.MyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class MyController {

	private final MyService myService;
	private AuthenticationManager authenticationManager;

	/* */
	@GetMapping(path = "/test")
	public String check() {
		return "All is Well";
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<GeneralResponse> login(@RequestBody LoginDto loginDto){
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", "login Successfully"));
	}

	@PostMapping(path = "/register")
	public ResponseEntity<GeneralResponse> register(@RequestBody RegisterDto registerDto) {
		ShowDeatilsDto details = myService.register(registerDto);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", details));
	}
	
	@GetMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> getEmployee(@PathVariable String employeeId) {
		ShowDeatilsDto showDeatilsDto=myService.getEmployeebyId(employeeId);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", showDeatilsDto));
		
	}
	
	@GetMapping(path = "/employees")
	public ResponseEntity<GeneralResponse> getEmployees(){
		List<Employee> employees = myService.getEmployees();
		 return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", employees));
	}
	
	@PutMapping(path = "update")
	public ResponseEntity<GeneralResponse> updateEmployee(@RequestBody RegisterDto registerDto){
		ShowDeatilsDto showDeatilsDto = myService.updateEmployee(registerDto); 
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "message", "error", showDeatilsDto)); 
		
	}
}
