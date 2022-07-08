package com.te.learnspringboot2.controlller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.te.learnspringboot2.entity.dto.EmployeeDto;
import com.te.learnspringboot2.exception.EmployeeNotFoundException;
import com.te.learnspringboot2.response.GeneralResponse;
import com.te.learnspringboot2.service.EmpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/c1")
public class EmpController {

	private final EmpService empService;

	@GetMapping(path = "/employees")
	public ResponseEntity<GeneralResponse> findAllEmployees() {

		return ResponseEntity.ok()
				.body(new GeneralResponse(
						ServletUriComponentsBuilder.fromCurrentContextPath().path("/employees").toUriString(),
						HttpStatus.OK, "error", "message", empService.findAllEmployees()));
	}

	@PostMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> resisterEmployee(@RequestBody EmployeeDto employeeDto) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/employer").toUriString());
		return ResponseEntity.created(uri)
				.body(new GeneralResponse(
						ServletUriComponentsBuilder.fromCurrentContextPath().path("/employees").toUriString(),
						HttpStatus.CREATED, "error", "message", empService.saveEmployee(employeeDto)));
	}

	@GetMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> getEmployee(@PathVariable String employeeId) {
		EmployeeDto employeeDto = empService.findByEmpId(employeeId);
		if (employeeDto != null) {
			return ResponseEntity.ok()
					.body(new GeneralResponse(ServletUriComponentsBuilder.fromCurrentContextPath()
							.path("/employees/" +employeeId).toUriString(), HttpStatus.OK, "error", "message",
							employeeDto));
		}
		// TODO logic for throw exception
		throw new EmployeeNotFoundException("Employee with given employee id " + employeeId + " is not present in Db");
	}
}
