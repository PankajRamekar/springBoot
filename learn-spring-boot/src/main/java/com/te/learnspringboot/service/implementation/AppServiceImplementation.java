package com.te.learnspringboot.service.implementation;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.learnspringboot.entity.Employee;
import com.te.learnspringboot.entity.dto.EmployeeDto;
import com.te.learnspringboot.repository.AppRepository;
import com.te.learnspringboot.service.AppService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AppServiceImplementation implements AppService {

	private final AppRepository appRepository;

	@Override
	public EmployeeDto getEmployee(int employeeId) {
		Employee employee = appRepository.getEmployee(employeeId);
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		employee = appRepository.saveEmployee(employee);
		BeanUtils.copyProperties(employeeDto, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeDto updateEmployee(int employeeId, EmployeeDto employeeDto) {
		Employee employee = appRepository.getEmployee(employeeId);
		BeanUtils.copyProperties(employeeDto, employee);
		employee = appRepository.saveEmployee(employee);
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		boolean isDeleted = appRepository.deleteEmployee(employeeId);
		return isDeleted;
	}

}
