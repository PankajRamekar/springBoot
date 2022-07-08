package com.te.learnspringsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.te.learnspringboot.response.GeneralResponse;
import com.te.learnspringsecurity.service.AppService;
import com.te.springbootsecurity.entity.dto.RegisterDto;
import com.te.springbootsecurity.entity.dto.ShowDeatilsDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppController {
	
	private final AppService appService;
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<GeneralResponse> getEmployee(@PathVariable String empId) {
		
				ShowDeatilsDto employeeDto=appService.getEmployee(empId);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "All Working Ok", null, employeeDto));

	}

	@PostMapping("/employee")
	public ResponseEntity<GeneralResponse> saveEmployee(@RequestBody RegisterDto registerDto) {
		ShowDeatilsDto showDeatilsDto =appService.saveEmployee(registerDto);
		
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, null, showDeatilsDto));

	}
	
}
