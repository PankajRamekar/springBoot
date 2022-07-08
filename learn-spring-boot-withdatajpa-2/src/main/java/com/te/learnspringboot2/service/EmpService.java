package com.te.learnspringboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.learnspringboot2.entity.dto.EmployeeDto;

@Service
public interface EmpService {
	public EmployeeDto findByEmpId(String employeeId);

	List<EmployeeDto> findAllEmployees();

	public EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	public EmployeeDto updateEmployee(String employeeId, EmployeeDto employeeDto);
	
	boolean deleteEmployee(String employeeId);
}
