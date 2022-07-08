package com.te.learnspringboot.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.learnspringboot.entity.Employee;
import com.te.learnspringboot.entity.dto.EmployeeDto;
import com.te.learnspringboot.repository.AppRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppServiceImplementation implements AppService {
	
	private final AppRepository appRepository;

	@Override
	public List<EmployeeDto> findAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDto findEmployee(int empId) {
		// TODO Auto-generated method stub
		Employee employee=appRepository.findEmployee(empId);
		EmployeeDto employeeDto= new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		employee=appRepository.saveEmployee(employee);
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeDto updateEmployee(int empId,EmployeeDto employeeDto) {
		Employee employee=appRepository.findEmployee(empId);
		BeanUtils.copyProperties(employeeDto, employee);
		Employee saveEmployee = appRepository.saveEmployee(employee);
		BeanUtils.copyProperties( saveEmployee, employeeDto);
		return employeeDto;
	}

	@Override
	public Boolean deleteEmployee(int empId) {
		Boolean isDeleted=appRepository.removeEmployee(empId);
		return isDeleted;
	}

}
