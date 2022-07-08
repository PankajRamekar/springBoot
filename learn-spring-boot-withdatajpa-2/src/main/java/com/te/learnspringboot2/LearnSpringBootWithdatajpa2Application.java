package com.te.learnspringboot2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.te.learnspringboot2.entity.Employee;
import com.te.learnspringboot2.entity.EmployeeAddress;
import com.te.learnspringboot2.entity.enums.AddressType;
import com.te.learnspringboot2.entity.enums.BloodGroup;
import com.te.learnspringboot2.entity.enums.Degree;
import com.te.learnspringboot2.entity.enums.Nationality;
import com.te.learnspringboot2.repository.EmpRepository;
import com.te.learnspringboot2.service.EmpService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class LearnSpringBootWithdatajpa2Application {
	private final EmpService empService;

	public static void main(String[] args) {

		SpringApplication.run(LearnSpringBootWithdatajpa2Application.class, args);
	}

	@Bean
	public CommandLineRunner saveINdb(EmpRepository empRepository) {

		return args -> {
			Optional<Employee> findByEmployeeId = empRepository.findByEmployeeId("TY01");
			if (!findByEmployeeId.isPresent()) {
				Employee employee = new Employee();
				employee.setEmployeeId("TY01");
				employee.setEmployeeName("Name01");
				employee.setEmployeeBloodGroup(BloodGroup.B_POSITIVE);
				employee.setEmployeeDateOfBirth(LocalDate.now());
				employee.setEmployeeDegree(Degree.BE_CSE);
				employee.setEmployeeNationality(Nationality.INDIA);
				EmployeeAddress address = new EmployeeAddress();
				address.setAddressType(AddressType.PERMANANT);
				address.setLocality("banglore");
				address.setStreet("Street01");

				employee.setEmployeeAddress(Arrays.asList(address));
				empRepository.save(employee);
			}
		};

	}

}
