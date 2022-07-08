package com.te.springbootsecurity.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GeneralResponse {
	private HttpStatus httpStatus;
	private String message;
	private String error;
	private LocalDateTime timeStamps = LocalDateTime.now();
	private Object data;

	public GeneralResponse(HttpStatus httpStatus, String message, String error, Object data) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.error = error;
		this.data = data;
	}

}
