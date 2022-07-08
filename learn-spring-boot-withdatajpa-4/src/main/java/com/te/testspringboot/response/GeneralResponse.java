package com.te.testspringboot.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GeneralResponse {

	private HttpStatus httpStatus;
	private String error;
	private String message;
	private Object data;
}
