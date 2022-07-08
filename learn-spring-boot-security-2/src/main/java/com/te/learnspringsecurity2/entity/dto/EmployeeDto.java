package com.te.learnspringsecurity2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeePass;
	private String EmployeeRole;
	
}
