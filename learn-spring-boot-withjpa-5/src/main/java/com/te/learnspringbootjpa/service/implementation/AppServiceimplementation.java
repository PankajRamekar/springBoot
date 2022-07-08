package com.te.learnspringbootjpa.service.implementation;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.learnspringbootjpa.entity.Employee;
import com.te.learnspringbootjpa.entity.dto.EmployeeDto;
import com.te.learnspringbootjpa.repository.AppRepository;
import com.te.learnspringbootjpa.service.AppService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppServiceimplementation implements AppService {

	private final AppRepository appRepository;

	@Override
	public EmployeeDto getEmployee(int empId) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = appRepository.findById(empId);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			EmployeeDto employeeDto = new EmployeeDto();
			BeanUtils.copyProperties(employee, employeeDto);
			return employeeDto;
		}
		return null;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		employee = appRepository.save(employee);
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeDto updateEmployee(int empId, EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = appRepository.findById(empId);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			BeanUtils.copyProperties(employeeDto, employee);
			employee = appRepository.save(employee);
			BeanUtils.copyProperties(employee, employeeDto);
			return employeeDto;
		}
		return null;
	}

	@Override
	public Boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = appRepository.findById(empId);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			appRepository.delete(employee);
			return true;
		}
		return false;
	}

}
