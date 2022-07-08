package com.te.learnspringsecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.learnspringsecurity.entity.Employee;
import com.te.learnspringsecurity.entity.dto.RegisterDto;
import com.te.learnspringsecurity.entity.dto.ShowDeatilsDto;

@Service
public interface AppService {

	
		public ShowDeatilsDto register(RegisterDto registerDto);

		public List<Employee> getEmployees();

		public ShowDeatilsDto updateEmployee(RegisterDto registerDto);

		public ShowDeatilsDto getEmployeebyId(String employeeId);

		
	}


