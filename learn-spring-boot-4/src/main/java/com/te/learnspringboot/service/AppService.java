package com.te.learnspringboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.learnspringboot.entity.dto.EmployeeDto;

@Service
public interface AppService {

	List<EmployeeDto> findAllEmployee();

	EmployeeDto findEmployee(int empId);

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployee(int empId, EmployeeDto employeeDto);

	Boolean deleteEmployee(int empId);

}
