package com.te.learnspringboot2.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AddressType {
	TEMPORARY("TEMPORARY"), PERMANANT("PERMANANT");

	private final String empAddressType;

}
