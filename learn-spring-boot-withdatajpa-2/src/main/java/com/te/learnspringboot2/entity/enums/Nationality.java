package com.te.learnspringboot2.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Nationality {
INDIA("INDIA") , ENGLAND("ENGLAND") , SRILANKA("SRILANKA");

private final String empNationality;
}
