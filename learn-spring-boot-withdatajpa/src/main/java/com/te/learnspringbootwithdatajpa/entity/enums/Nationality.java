package com.te.learnspringbootwithdatajpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Nationality {
	
	INDIAN("INDIAN"), SHRILANKA("SHRILANKA");
	
	private final String employeeNationality;

}
