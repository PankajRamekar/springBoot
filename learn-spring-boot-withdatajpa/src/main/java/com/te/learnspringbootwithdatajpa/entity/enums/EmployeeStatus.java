package com.te.learnspringbootwithdatajpa.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EmployeeStatus {
	ABSCOND("ABSCOND"), TERMINATED("TERMINATED"), ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

	private final String employeeStatus;
}
