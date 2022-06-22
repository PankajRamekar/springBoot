package com.te.learnspringboot.cotroller;

import java.util.ArrayList;
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
@RequestMapping(path = "/c1")
public class SpringBootController {
	private final AppService appService;
 
	@GetMapping(path = "/employeeall")
	public ResponseEntity<GeneralResponse> getEmployees() {
		List<EmployeeDto> list= new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			EmployeeDto employee = appService.getEmployee(i);
			if(employee!=null) {
				list.add(employee);
			}
			
		}

		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "success", list));

	}

	@GetMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> getEmployee(@PathVariable int employeeId) {
		EmployeeDto employeeDto = appService.getEmployee(employeeId);
		if (employeeDto != null) {
			return ResponseEntity.ok()
					.body(new GeneralResponse(HttpStatus.OK, null, "success", "hii!  " + employeeDto));
		}
		return ResponseEntity.badRequest().body(
				new GeneralResponse(HttpStatus.BAD_REQUEST, null, "EMployee Not Found", "BadRequest  " + employeeDto));
	}

	@PostMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto employeeDto1 = appService.saveEmployee(employeeDto);
		if (employeeDto1 != null) {
			return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "success", employeeDto));
		}
		return ResponseEntity.badRequest()
				.body(new GeneralResponse(HttpStatus.BAD_REQUEST, null, "Not Saved", employeeDto));
	}

	@PutMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> updateEmployee(@PathVariable int employeeId,
			@RequestBody EmployeeDto employeeDto) {
		EmployeeDto updateEmployeeDto = appService.updateEmployee(employeeId, employeeDto);
		if (updateEmployeeDto != null) {
			return ResponseEntity.ok()
					.body(new GeneralResponse(HttpStatus.OK, null,"updated Employee data",updateEmployeeDto));
		}
		return ResponseEntity.badRequest()
				.body(new GeneralResponse(HttpStatus.BAD_REQUEST, null, "Notsuccess", "Not updated Employee data"));
	}

	@DeleteMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> deleteEmployee(@PathVariable int employeeId) {
		boolean deleteEmployee = appService.deleteEmployee(employeeId);
		if (deleteEmployee == true) {
			return ResponseEntity.ok()
					.body(new GeneralResponse(HttpStatus.OK, null, "success", "Deleted Employee data"));
		}
		return ResponseEntity.badRequest()
				.body(new GeneralResponse(HttpStatus.BAD_REQUEST, null, "NOt success", "No Deleted Employee data"));
	}

}
