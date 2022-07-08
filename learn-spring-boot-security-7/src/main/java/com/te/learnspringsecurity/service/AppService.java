package com.te.learnspringsecurity.service;

import org.springframework.stereotype.Service;

import com.te.springbootsecurity.entity.dto.RegisterDto;
import com.te.springbootsecurity.entity.dto.ShowDeatilsDto;
@Service
public interface AppService {

	ShowDeatilsDto getEmployee(String empId);

	ShowDeatilsDto saveEmployee(RegisterDto registerDto);

	

}
