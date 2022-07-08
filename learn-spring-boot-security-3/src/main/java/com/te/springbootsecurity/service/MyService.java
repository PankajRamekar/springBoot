package com.te.springbootsecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.springbootsecurity.entity.Admin;
import com.te.springbootsecurity.entity.Employee;
import com.te.springbootsecurity.entity.dto.RegisterDto;
import com.te.springbootsecurity.entity.dto.ShowDeatilsDto;

@Service
public interface MyService {
	public ShowDeatilsDto register(RegisterDto registerDto);

	public List<Employee> getEmployees();

	public ShowDeatilsDto updateEmployee(RegisterDto registerDto);

	public ShowDeatilsDto getEmployeebyId(String employeeId);

	
}
