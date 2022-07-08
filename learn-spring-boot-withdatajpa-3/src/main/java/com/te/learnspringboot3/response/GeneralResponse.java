package com.te.learnspringboot3.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor 
@Getter
@Setter
public class GeneralResponse {
	private HttpStatus httpStatus;
	private String error;
	private String message;
	private Object data;
	
	
}
