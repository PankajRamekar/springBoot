package com.te.learnspringboot.controller;

import java.util.List;

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

import com.te.learnspringboot.entity.dto.EmployeeDto;
import com.te.learnspringboot.response.GeneralResponse;
import com.te.learnspringboot.service.AppService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class AppController {
	
	private final AppService appService;

	@GetMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> getEmployee() {
					List<EmployeeDto> employees =appService.findAllEmployee();
		return ResponseEntity.ok()
				.body(new GeneralResponse(HttpStatus.HTTP_VERSION_NOT_SUPPORTED.OK, "message ", "error", employees));
	}

	@GetMapping(path = "/employee/{empId}")
	public ResponseEntity<GeneralResponse> getEmployee(@PathVariable int empId) {
			EmployeeDto employeeDto=appService.findEmployee(empId);
		return ResponseEntity.ok()
				.body(new GeneralResponse(HttpStatus.HTTP_VERSION_NOT_SUPPORTED.OK, "message ", "error", employeeDto));
	}

	@PostMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> saveEmployee(@RequestBody EmployeeDto employeeDto) {
			EmployeeDto employee=appService.saveEmployee(employeeDto);
		return ResponseEntity.ok()
				.body(new GeneralResponse(HttpStatus.HTTP_VERSION_NOT_SUPPORTED.OK, "message ", "error", employee));

	}

	@PutMapping(path = "/employee/{empId}")
	public ResponseEntity<GeneralResponse> updateEmployee(@PathVariable int empId ,@RequestBody EmployeeDto employeeDto) {
				EmployeeDto employee =appService.updateEmployee(empId,employeeDto);
		return ResponseEntity.ok()
				.body(new GeneralResponse(HttpStatus.HTTP_VERSION_NOT_SUPPORTED.OK, "message ", "error", employee));

	}

	@DeleteMapping(path = "/employee/{empId}")
	public ResponseEntity<GeneralResponse> removeEmployee(@PathVariable int empId) {
							Boolean isDeleted=appService.deleteEmployee(empId);
		if(isDeleted) {
		return ResponseEntity.ok()
				.body(new GeneralResponse(HttpStatus.HTTP_VERSION_NOT_SUPPORTED.OK, "message ", "error", "employee Deleted from database"));
		}
		return ResponseEntity.badRequest()
				.body(new GeneralResponse(HttpStatus.HTTP_VERSION_NOT_SUPPORTED.BAD_REQUEST, "message ", "error", "employee Not Deleted from database"));
	}
}










