package com.te.learnspringsecurity.service.implementation;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.learnspringsecurity.repository.AppUsersRepository;
import com.te.learnspringsecurity.repository.RegisterRepository;
import com.te.learnspringsecurity.service.AppService;
import com.te.springbootsecurity.entity.Address;
import com.te.springbootsecurity.entity.AppUser;
import com.te.springbootsecurity.entity.Employee;
import com.te.springbootsecurity.entity.Role;
import com.te.springbootsecurity.entity.dto.RegisterDto;
import com.te.springbootsecurity.entity.dto.ShowDeatilsDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppServiceImplementation implements AppService {

	//private final PasswordEncoder passwordEncoder;
	private final RegisterRepository registerRepository;
	private final AppUsersRepository appUsersRepository;
	
	@Override
	public ShowDeatilsDto getEmployee(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShowDeatilsDto saveEmployee(RegisterDto registerDto) {
		// TODO Auto-generated method stub

		Employee employee = new Employee();
		employee.setEmployeeId(registerDto.getEmployeeId());
		employee.setEmployeeName(registerDto.getEmployeeName());
		employee.setEmployeeEmail(registerDto.getEmployeeEmail());

		Address address = new Address();
		address.setStreet(registerDto.getStreet());
		address.setCity(registerDto.getCity());
		employee.setAddress(address);
		registerRepository.save(employee);

		AppUser appUser = new AppUser();
		appUser.setUsername(registerDto.getEmployeeId());
		appUser.setPassword((registerDto.getPassword()));

		Role role = new Role();
		role.setRoleName(registerDto.getRole());
		appUser.setRoles(Arrays.asList(role));
		appUsersRepository.save(appUser);

		ShowDeatilsDto showDeatilsDto = new ShowDeatilsDto();
		BeanUtils.copyProperties(registerDto, showDeatilsDto);
		return showDeatilsDto;

		
	}

}
