package com.te.learnspringboot2.entity.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.te.learnspringboot2.entity.enums.AddressType;

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
public class EmployeeAddressDto {
	
	private String street;
	private String locality;
	@Enumerated(EnumType.STRING)
	private AddressType addressType;

//	@ManyToOne
//	private EmployeeDto employeeDto;
//	

}
