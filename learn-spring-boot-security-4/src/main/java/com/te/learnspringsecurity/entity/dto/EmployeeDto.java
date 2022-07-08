package com.te.learnspringsecurity.entity.dto;

import javax.persistence.OneToOne;

import com.te.learnspringsecurity.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class EmployeeDto {
	
	private String empName;
	private int empAge;
	
	@OneToOne
	private Address address;

}
