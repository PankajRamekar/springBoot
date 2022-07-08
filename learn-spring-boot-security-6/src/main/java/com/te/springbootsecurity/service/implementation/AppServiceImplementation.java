

package com.te.springbootsecurity.service.implementation;

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

import com.te.springbootsecurity.entity.Address;
import com.te.springbootsecurity.entity.AppUser;
import com.te.springbootsecurity.entity.Employee;
import com.te.springbootsecurity.entity.Role;
import com.te.springbootsecurity.entity.dto.RegisterDto;
import com.te.springbootsecurity.entity.dto.ShowDeatilsDto;
import com.te.springbootsecurity.repository.AppUserRepository;
import com.te.springbootsecurity.repository.EmployeeRepository;
import com.te.springbootsecurity.service.MyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppServiceImplementation implements MyService, UserDetailsService {
	private final AppUserRepository appUserRepository;
	private final EmployeeRepository employeeRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<AppUser> optional = appUserRepository.findByUser(username);
		if (optional.isPresent()) {
			AppUser appUser = optional.get();

			List<SimpleGrantedAuthority> authorities = appUser.getRoles().stream().map(r -> {
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(r.getRoleName());
				return simpleGrantedAuthority;
			}).collect(Collectors.toList());

			return new User(appUser.getUsername(), appUser.getPassword(), authorities);
		}

		throw new UsernameNotFoundException("user not found");
	}

	@Override
	public ShowDeatilsDto register(RegisterDto registerDto) {

		Employee employee = new Employee();
		employee.setEmployeeId(registerDto.getEmployeeId());
		employee.setEmployeeName(registerDto.getEmployeeName());
		employee.setEmployeeEmail(registerDto.getEmployeeEmail());

		Address address = new Address();
		address.setStreet(registerDto.getStreet());
		address.setCity(registerDto.getCity());
		employee.setAddress(address);
		employeeRepository.save(employee);

		AppUser appUser = new AppUser();
		appUser.setUsername(registerDto.getEmployeeId());
		appUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));

		Role role = new Role();
		role.setRoleName(registerDto.getRole());
		appUser.setRoles(Arrays.asList(role));
		appUserRepository.save(appUser);
		
		ShowDeatilsDto showDeatilsDto = new ShowDeatilsDto();
		BeanUtils.copyProperties(registerDto, showDeatilsDto);
		return showDeatilsDto;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShowDeatilsDto updateEmployee(RegisterDto registerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShowDeatilsDto getEmployeebyId(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
