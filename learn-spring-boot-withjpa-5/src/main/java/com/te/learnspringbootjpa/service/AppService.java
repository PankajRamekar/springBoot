package com.te.learnspringbootjpa.service;

import org.springframework.stereotype.Service;

import com.te.learnspringbootjpa.entity.dto.EmployeeDto;

@Service
public interface AppService {

	EmployeeDto getEmployee(int empId);

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployee(int empId, EmployeeDto employeeDto);

	Boolean deleteEmployee(int empId);

}
