package com.te.learnspringsecurity.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShowDeatilsDto {

	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String street;
	private String city;
	
}
