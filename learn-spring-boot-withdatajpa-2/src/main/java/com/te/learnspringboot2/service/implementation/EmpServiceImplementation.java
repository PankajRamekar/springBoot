package com.te.learnspringboot2.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.learnspringboot2.entity.Employee;
import com.te.learnspringboot2.entity.EmployeeAddress;
import com.te.learnspringboot2.entity.dto.EmployeeAddressDto;
import com.te.learnspringboot2.entity.dto.EmployeeDto;
import com.te.learnspringboot2.repository.EmpRepository;
import com.te.learnspringboot2.service.EmpService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmpServiceImplementation implements EmpService {

	private final EmpRepository empRepository;

	@Override
	public List<EmployeeDto> findAllEmployees() {
		List<EmployeeDto> employeeDtos = new ArrayList<>();

		empRepository.findAll().stream().forEach(e -> {
			EmployeeDto employeeDto = new EmployeeDto();
			List<EmployeeAddressDto> addressDtos = new ArrayList<>();
			BeanUtils.copyProperties(e, employeeDto);
			e.getEmployeeAddress().stream().forEach(a -> {
				EmployeeAddressDto employeeAddressDto = new EmployeeAddressDto();
				BeanUtils.copyProperties(a, employeeAddressDto);
				addressDtos.add(employeeAddressDto);

			});
			employeeDto.setEmployeeAddress(addressDtos);
			employeeDtos.add(employeeDto);
		});

		return employeeDtos;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		List<EmployeeAddress> addresses = new ArrayList<>();
		employeeDto.getEmployeeAddress().stream().forEach(aDto -> {
			EmployeeAddress address = new EmployeeAddress();
			BeanUtils.copyProperties(aDto, address);
			addresses.add(address);
		});
		employee.setEmployeeAddress(addresses);
		employee = empRepository.save(employee);
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeDto updateEmployee(String employeeId, EmployeeDto employeeDto) {
		Optional<Employee> findByEmployeeId = empRepository.findByEmployeeId(employeeId);
		if (findByEmployeeId.isPresent()) {
			Employee employee = findByEmployeeId.get();
			BeanUtils.copyProperties(employeeDto, employee);
			List<EmployeeAddress> addresses = new ArrayList<>();
			employeeDto.getEmployeeAddress().stream().forEach(aDto -> {
				EmployeeAddress employeeAddress = new EmployeeAddress();
				BeanUtils.copyProperties(aDto, employeeAddress);
				addresses.add(employeeAddress);

			});
			employee.setEmployeeAddress(addresses);
			employee = empRepository.save(employee);
			BeanUtils.copyProperties(employee, employeeDto);
			return employeeDto;
		}
		return null;
	}

	@Override
	public EmployeeDto findByEmpId(String employeeId) {
		Optional<Employee> findByEmployeeId = empRepository.findByEmployeeId(employeeId);
		if (findByEmployeeId.isPresent()) {
			EmployeeDto employeeDto = new EmployeeDto();

			Employee employee = findByEmployeeId.get();
			BeanUtils.copyProperties(employeeDto, employee);
			List<EmployeeAddress> addresses = new ArrayList<>();
			employeeDto.getEmployeeAddress().stream().forEach(aDto -> {
				EmployeeAddress employeeAddress = new EmployeeAddress();
				BeanUtils.copyProperties(aDto, employeeAddress);
				addresses.add(employeeAddress);

			});
			employee.setEmployeeAddress(addresses);

			BeanUtils.copyProperties(employee, employeeDto);
			return employeeDto;
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		// TODO Auto-generated method stub
		return false;
	}
}