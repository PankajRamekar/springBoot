package com.te.learnspringsecurity.services;

import org.springframework.stereotype.Service;

import com.te.learnspringsecurity.entity.dto.EmployeeDto;

@Service
public interface AppUserService {
	public EmployeeDto registerEmployee(EmployeeDto employeeDto);
}
