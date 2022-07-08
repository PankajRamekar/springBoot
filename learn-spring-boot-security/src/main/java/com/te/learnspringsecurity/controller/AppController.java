package com.te.learnspringsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learnspringsecurity.entity.dto.EmployeeDto;
import com.te.learnspringsecurity.entity.dto.LoginDto;
import com.te.learnspringsecurity.jwt.JwtUtils;
import com.te.learnspringsecurity.response.GeneralResponse;
import com.te.learnspringsecurity.services.AppUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class AppController {

	private final JwtUtils jwtUtils;
	private final AuthenticationManager authenticationManager;
	private final AppUserService appUserService;

	/* public api */
	@GetMapping("/check")
	public String appTest() {
		return "This method was used";
	}

	/* public api */
	@PostMapping(path = "/login")
	public ResponseEntity<GeneralResponse> login(@RequestBody LoginDto loginDto) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		String token = jwtUtils.generateToken(loginDto.getUsername());
		return ResponseEntity.ok().body(new GeneralResponse(token, HttpStatus.OK, null, null, "Login!"));

	}

	/* to register the employee */
	@PostMapping(path ="/register")
	public ResponseEntity<GeneralResponse> registerMentor(@RequestBody EmployeeDto employeeDto) {
			EmployeeDto employeeDto2 = appUserService.registerEmployee(employeeDto);
			String token= jwtUtils.generateToken(employeeDto.toString());
		return ResponseEntity.ok().body(new GeneralResponse(token, HttpStatus.OK, null, null,employeeDto2 ));

	}

	/* admin api */
	@GetMapping(path = "/admin")
	public ResponseEntity<GeneralResponse> onlyAccesibletoAdmin() {
		return ResponseEntity.ok().body(new GeneralResponse(null, HttpStatus.OK, null, null, "only access to Admin"));
	}

	/* mentor api */
	@GetMapping(path = "/mentor")
	public ResponseEntity<GeneralResponse> onlyAccesibletoMentor() {
		return ResponseEntity.ok().body(new GeneralResponse(null, HttpStatus.OK, null, null, "only access to mentor"));
	}

	/* employee api */
	@GetMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> onlyAccesibletoEmployee() {
		return ResponseEntity.ok()
				.body(new GeneralResponse(null, HttpStatus.OK, null, null, "only access to employee"));
	}

	/* only admin access */
	@GetMapping(path = "/admin/{adminId}")
	public ResponseEntity<GeneralResponse> getAdminInfo(@PathVariable String adminId) {
		return ResponseEntity.ok().body(new GeneralResponse(adminId, HttpStatus.OK, null, null, "admin data"));

	}

	/* admin+mentor access */
	@GetMapping(path = "/mentor/{mentorId}")
	public ResponseEntity<GeneralResponse> getMentorInfo(@PathVariable String mentorId) {
		return ResponseEntity.ok().body(new GeneralResponse(mentorId, HttpStatus.OK, null, null, "mentor data"));

	}

	/* admin+mentor+employee access */
	@GetMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> getemployeeInfo(@PathVariable String employeeId) {
		return ResponseEntity.ok().body(new GeneralResponse(employeeId, HttpStatus.OK, null, null, "employee data"));

	}

}
