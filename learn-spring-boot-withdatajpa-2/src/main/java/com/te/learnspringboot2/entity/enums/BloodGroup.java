package com.te.learnspringboot2.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BloodGroup {
	A_POSITIVE("A_POSITIVE"), A_NEGATIVE("A_NEGATIVE"), B_POSITIVE("B_POSITIVE"), B_NEGATIVE("B_NEGATIVE"),
	AB_POSITIVE("AB_POSITIVE"), AB_NEGATIVE("AB_NEGATIVE"), O_POSITIVE("O_POSITIVE"), O_NEGATIVE("O_NEGATIVE");

	private final String empBloodGroup;
}
