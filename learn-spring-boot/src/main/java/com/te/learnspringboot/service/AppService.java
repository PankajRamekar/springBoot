package com.te.learnspringboot.service;

import org.springframework.stereotype.Service;

import com.te.learnspringboot.entity.dto.EmployeeDto;

@Service
public interface AppService {

	public abstract EmployeeDto getEmployee(int employeeId);

	public abstract EmployeeDto saveEmployee(EmployeeDto employeeDto);

	public abstract EmployeeDto updateEmployee(int employeeId, EmployeeDto employeeDto);

	public abstract boolean deleteEmployee(int employeeId);
}
