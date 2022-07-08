package com.te.springbootsecurity.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterDto {

	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String street;
	private String city;
	private String role;
	private String password;
}
