package com.te.learnspringboot2.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Degree {
	BE_CSE("BE_CSE"), BE_NONCSE("BE_NONCSE"), PG("PG"), PHD("PHD");

	private final String empDegree;
}
