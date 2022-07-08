 package com.te.learnspringsecurity.services.implementation;

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

import com.te.learnspringsecurity.entity.AppUser;
import com.te.learnspringsecurity.entity.Employee;
import com.te.learnspringsecurity.entity.Mentor;
import com.te.learnspringsecurity.entity.Role;
import com.te.learnspringsecurity.entity.dto.EmployeeDto;
import com.te.learnspringsecurity.repository.AppUserRepository;
import com.te.learnspringsecurity.repository.EmployeeRepository;
import com.te.learnspringsecurity.repository.MentorRepository;
import com.te.learnspringsecurity.services.AppUserService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserServiceimplementation implements AppUserService, UserDetailsService {

	private final AppUserRepository appUserRepository;
	private final EmployeeRepository employeeRepository;
	private final MentorRepository mentorRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.error("my first log");
		// 1. Find Appuser from database using username
		// 2. If appuser is present , convert Appuser obj into Spring security user obj
		// and return user object
		// 3. oer else throw new UserNot FoundExcepion

		Optional<AppUser> optional = appUserRepository.findByUsername(username);
		if (optional.isPresent()) {
			AppUser appUser = optional.get();
			List<SimpleGrantedAuthority> authorities = appUser.getRoles().stream().map(r -> {
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(r.getRoleName());
				return simpleGrantedAuthority;
			}).collect(Collectors.toList());
			return new User(appUser.getUsername(), appUser.getPassword(), authorities);
		}
		throw new UsernameNotFoundException("user not exist in DB");
	}

	@Override
	public EmployeeDto registerEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		if(employeeDto.getEmployeeRole()=="employee") {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		employee = employeeRepository.save(employee);
		AppUser appUser= new AppUser();
		appUser.setUsername(employee.getEmployeeId());
		appUser.setPassword(passwordEncoder.encode((employee.getEmployeePass())));
		Role role= new Role();
		role.setRoleName(employee.getEmployeeRole());
		appUser.setRoles(Arrays.asList(role));
		employee.setAppUser(appUser);
		return employeeDto;
	}
		else {
			Mentor mentor= new Mentor();
			BeanUtils.copyProperties(employeeDto,mentor );
			mentor = mentorRepository.save(mentor);
			AppUser appUser= new AppUser();
			appUser.setUsername(mentor.getMentorId());
			appUser.setPassword(passwordEncoder.encode((mentor.getMentorPass())));
			Role role= new Role();
			role.setRoleName(mentor.getMentorRole());
			appUser.setRoles(Arrays.asList(role));
			mentor.setAppUser(appUser);
			return employeeDto;
		}
		
	}
}


