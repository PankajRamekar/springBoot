package com.te.learnspringboot3.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AddressType {
	
	PARMANENT("PARMANENT"), TEMPORARY("TEMPORARY");
	
	private final String AddressType;
	
}
