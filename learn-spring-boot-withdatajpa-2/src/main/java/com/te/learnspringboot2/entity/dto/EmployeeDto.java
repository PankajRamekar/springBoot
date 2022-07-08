package com.te.learnspringboot2.entity.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.te.learnspringboot2.entity.enums.BloodGroup;
import com.te.learnspringboot2.entity.enums.Degree;
import com.te.learnspringboot2.entity.enums.Gender;
import com.te.learnspringboot2.entity.enums.Nationality;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {
	
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private LocalDate employeeDateOfBirth;
	private LocalDate employeeDateOfJoining;
	private String employeeDesignation;

	@Enumerated(EnumType.STRING)
	private Nationality employeeNationality;
	@Enumerated(EnumType.STRING)
	private Gender employeeGender;
	@Enumerated(EnumType.STRING)
	private BloodGroup employeeBloodGroup;
	@Enumerated(EnumType.STRING)
	private Degree employeeDegree;
	
	//@OneToMany(cascade = CascadeType.ALL)
	private List<EmployeeAddressDto> employeeAddress; 


}

