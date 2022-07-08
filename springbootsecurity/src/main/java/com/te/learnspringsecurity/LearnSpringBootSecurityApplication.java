package com.te.learnspringsecurity;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.te.learnspringsecurity.entity.Admin;
import com.te.learnspringsecurity.entity.AppUser;
import com.te.learnspringsecurity.entity.Employee;
import com.te.learnspringsecurity.entity.Mentor;
import com.te.learnspringsecurity.entity.Role;
import com.te.learnspringsecurity.repository.AdminRepository;
import com.te.learnspringsecurity.repository.AppUserRepository;
import com.te.learnspringsecurity.repository.EmployeeRepository;
import com.te.learnspringsecurity.repository.MentorRepository;
import com.te.learnspringsecurity.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class LearnSpringBootSecurityApplication {

	private final RoleRepository roleRepository;
	private final AdminRepository adminRepository;
	private final MentorRepository mentorRepository;
	private final EmployeeRepository employeeRepository;
	private final AppUserRepository appUserRepository;

	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootSecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner saveInDb() {
		return a -> {
			Optional<Role> findByRoleName = roleRepository.findByRoleName("ROLE_ADMIN");
			if (!findByRoleName.isPresent()) {
				Role adminRole = new Role();
				adminRole.setRoleName("ROLE_ADMIN");
				Role mentorRole = new Role();
				mentorRole.setRoleName("ROLE_MENTOR");
				Role employeeRole = new Role();
				employeeRole.setRoleName("ROLE_EMPLOYEE");
				roleRepository.save(adminRole);
				roleRepository.save(mentorRole);
				roleRepository.save(employeeRole);

				Admin admin = new Admin();
				admin.setAdminId("admin01");
				admin.setAdminName("AdminName01");
				admin.setAdminEmail("admemail01");
				adminRepository.save(admin);
				AppUser appUser = new AppUser();
				appUser.setUsername("admin01");
				appUser.setPassword(passwordEncoder.encode("qwerty"));
				appUser.setRoles(Arrays.asList(adminRole));
				appUserRepository.save(appUser);

				Mentor mentor = new Mentor();
				mentor.setMentorId("mentor01");
				mentor.setMentorName("mentor01");
				mentor.setMentorEmail("emailmentor");
				mentorRepository.save(mentor);
				AppUser appUser2 = new AppUser();
				appUser2.setUsername("mentor01");
				appUser2.setPassword(passwordEncoder.encode("qwerty"));
				appUser2.setRoles(Arrays.asList(mentorRole));
				appUserRepository.save(appUser2);

				Employee employee = new Employee();
				employee.setEmployeeId("emp01");
				employee.setEmployeeName("emp01");
				employee.setEmployeeEmail("empEmail");
				employeeRepository.save(employee);
				AppUser appUser3 = new AppUser();
				appUser3.setUsername("emp01");
				appUser3.setPassword(passwordEncoder.encode("qwerty"));
				appUser3.setRoles(Arrays.asList(employeeRole));
				appUserRepository.save(appUser3);
			}

		};
	}

}
