package com.te.learnspringsecurity.service.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.learnspringsecurity.entity.Address;
import com.te.learnspringsecurity.entity.AppUser;
import com.te.learnspringsecurity.entity.Employee;
import com.te.learnspringsecurity.entity.Roles;
import com.te.learnspringsecurity.entity.dto.RegisterDto;
import com.te.learnspringsecurity.entity.dto.ShowDeatilsDto;
import com.te.learnspringsecurity.repository.AppUserRepository;
import com.te.learnspringsecurity.repository.EmployeeRepository;
import com.te.learnspringsecurity.service.AppService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AppServiceImplementation implements AppService, UserDetailsService {

	private final AppUserRepository appUserRepository;
	private final EmployeeRepository employeeRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> optional = appUserRepository.findByUserName(username);
		if (optional.isPresent()) {
			AppUser appUser = optional.get();

			List<SimpleGrantedAuthority> authorities = appUser.getRoles().stream().map(r -> {
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(r.getRoleName());
				return simpleGrantedAuthority;
			}).collect(Collectors.toList());
			return new User(appUser.getUserName(), appUser.getPassword(), authorities);
		}

		return null;
	}

	@Override
	public ShowDeatilsDto register(RegisterDto registerDto) {
		// TODO Logic to save the details

		Employee employee = new Employee();
		BeanUtils.copyProperties(registerDto, employee);
		Address address = new Address();
		address.setCity(registerDto.getCity());
		address.setLocality(registerDto.getStreet());
		employee.setAddress(address);
		employee = employeeRepository.save(employee);
		Roles Roles = new Roles();
		Roles.setRoleName(registerDto.getRole()); // Roles.setRolesId(01);
		AppUser appUser = new AppUser();
		appUser.setRoles(Arrays.asList(Roles));
		appUser.setUserName(registerDto.getEmployeeId());
		appUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		Roles.setAppUsers(Arrays.asList(appUser));
		appUserRepository.save(appUser);
		ShowDeatilsDto showDeatilsDto = new ShowDeatilsDto();
		BeanUtils.copyProperties(registerDto, showDeatilsDto);
		return showDeatilsDto;

	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public ShowDeatilsDto updateEmployee(RegisterDto registerDto) {
		Optional<Employee> optional = employeeRepository.findById(registerDto.getEmployeeId());
		Employee employee = optional.get();
		BeanUtils.copyProperties(registerDto, employee);
		Address address = new Address();
		address.setCity(registerDto.getCity());
		address.setLocality(registerDto.getStreet());
		employee.setAddress(address);
		employee = employeeRepository.save(employee);
		Roles roles = new Roles();
		roles.setRoleName(registerDto.getRole());
		// Roles.setRolesId(01);
		AppUser appUser = new AppUser();
		appUser.setRoles(Arrays.asList(roles));
		appUser.setUserName(registerDto.getEmployeeId());
		appUser.setPassword(registerDto.getPassword());
		roles.setAppUsers(Arrays.asList(appUser));
		appUserRepository.save(appUser);
		ShowDeatilsDto showDeatilsDto = new ShowDeatilsDto();
		BeanUtils.copyProperties(registerDto, showDeatilsDto);
		return showDeatilsDto;

	}

	@Override
	public ShowDeatilsDto getEmployeebyId(String employeeId) {
		Employee employee = employeeRepository.getById(employeeId);
		ShowDeatilsDto deatilsDto = new ShowDeatilsDto();
		BeanUtils.copyProperties(employee, deatilsDto);
		return deatilsDto;
	}

}
