package com.te.learnspringsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learnspringsecurity.jwt.JwtUtils;
import com.te.springbootsecurity.entity.dto.LoginDto;
import com.te.springbootsecurity.entity.dto.RegisterDto;
import com.te.springbootsecurity.entity.dto.ShowDeatilsDto;
import com.te.springbootsecurity.response.GeneralResponse;
import com.te.springbootsecurity.service.MyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class AppController1 {

	private final JwtUtils jwtUtils;
	private final AuthenticationManager authenticationManager;
	private final MyService myService;

	/* public api */
	@GetMapping("/test")
	public String appTest() {
		return "This method was used";
	}

	/* public api */
	@PostMapping(path = "/login")
	public ResponseEntity<GeneralResponse> login(@RequestBody LoginDto loginDto) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		String token = jwtUtils.generateToken(loginDto.getUsername());
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, token, "Login!"));

	}

	/* to register the employee */

	@PostMapping(path = "/register")

	public ResponseEntity<GeneralResponse> registerMentor(@RequestBody RegisterDto registerDto) {
		ShowDeatilsDto showDeatilsDto = myService.register(registerDto);
		String token = jwtUtils.generateToken(registerDto.getEmployeeName());
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, token, showDeatilsDto));

	}

	/* admin api */

	@GetMapping(path = "/admin")

	public ResponseEntity<GeneralResponse> onlyAccesibletoAdmin() {
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, null, "Admin Access"));
	}

	/* mentor api */

	@GetMapping(path = "/mentor")

	public ResponseEntity<GeneralResponse> onlyAccesibletoMentor() {
		return ResponseEntity.ok().body(new GeneralResponse( HttpStatus.OK, null, null,"mentor Access"));
	}

	/*
	 * employee api
	 * 
	 * @GetMapping(path="/employee")
	 * 
	 * public ResponseEntity<GeneralResponse> onlyAccesibletoEmployee() { return
	 * ResponseEntity.ok() .body(new GeneralResponse(null, HttpStatus.OK, null,
	 * null, "only access to employee")); }
	 * 
	 * only admin access
	 * 
	 * @GetMapping(path="/admin/{adminId}")
	 * 
	 * public ResponseEntity<GeneralResponse> getAdminInfo(@PathVariable String
	 * adminId) { return ResponseEntity.ok().body(new GeneralResponse(adminId,
	 * HttpStatus.OK, null, null, "admin data"));
	 * 
	 * }
	 * 
	 * admin+mentor access
	 * 
	 * @GetMapping(path="/mentor/{mentorId}")
	 * 
	 * public ResponseEntity<GeneralResponse> getMentorInfo(@PathVariable String
	 * mentorId) { return ResponseEntity.ok().body(new GeneralResponse(mentorId,
	 * HttpStatus.OK, null, null, "mentor data"));
	 * 
	 * }
	 * 
	 * admin+mentor+employee access
	 * 
	 * @GetMapping(path="/employee/{employeeId}")
	 * 
	 * public ResponseEntity<GeneralResponse> getemployeeInfo(@PathVariable String
	 * employeeId) { return ResponseEntity.ok().body(new GeneralResponse(employeeId,
	 * HttpStatus.OK, null, null, "employee data"));
	 * 
	 * }
	 */

}
