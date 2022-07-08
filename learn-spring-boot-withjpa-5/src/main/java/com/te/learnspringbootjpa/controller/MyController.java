package com.te.learnspringbootjpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.te.learnspringbootjpa.entity.dto.EmployeeDto;
import com.te.learnspringbootjpa.entity.dto.LoginDto;
import com.te.learnspringbootjpa.jwt.JwtUtils;
import com.te.learnspringbootjpa.response.GeneralResponse;
import com.te.learnspringbootjpa.service.AppService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class MyController {

	private final AppService  appService;
	private final JwtUtils jwtUtils;
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<GeneralResponse> getEmployee(@PathVariable int empId) {
		EmployeeDto employeeDto=appService.getEmployee(empId);
		return ResponseEntity.ok().body(new GeneralResponse("uri", HttpStatus.OK, "message", "error", employeeDto));
		
	}
	@PostMapping("/login")
	public ResponseEntity<GeneralResponse> saveEmployee(@RequestBody LoginDto loginDto) {
			String token = jwtUtils.generateToken(loginDto.getUsername());
		return ResponseEntity.ok().body(new GeneralResponse("uri", HttpStatus.OK, "message", token, "Login Successfully"));
		
	}
	
	@PostMapping("/employee")
	public ResponseEntity<GeneralResponse> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeDto=appService.saveEmployee(employeeDto);
		return ResponseEntity.ok().body(new GeneralResponse("uri", HttpStatus.OK, "message", "error", employeeDto));
		
	}
	
	@PutMapping("/employee/{empId}")
	public ResponseEntity<GeneralResponse> updateEmployee(@PathVariable int empId, @RequestBody EmployeeDto employeeDto) {
		employeeDto=appService.updateEmployee(empId,employeeDto);
		return ResponseEntity.ok().body(new GeneralResponse("uri", HttpStatus.OK, "message", "error",employeeDto));
		
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<GeneralResponse> deleteEmployee(@PathVariable int empId) {
		Boolean isDeleted=appService.deleteEmployee(empId);
		if(isDeleted) {
		return ResponseEntity.ok().body(new GeneralResponse("uri", HttpStatus.OK, "message", "error", "Employee Deleted"));
		}
		return null;
	}
	
}
