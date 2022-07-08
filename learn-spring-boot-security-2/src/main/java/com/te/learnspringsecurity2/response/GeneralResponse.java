package com.te.learnspringsecurity2.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class GeneralResponse {

	private String token;
	private HttpStatus httpStatus;
	private String error;
	private String message;
	private LocalDateTime timestamp = LocalDateTime.now();
	private Object data;

	public GeneralResponse(String token, HttpStatus httpStatus, String error, String message, Object data) {
		super();
		this.token = token;
		this.httpStatus = httpStatus;
		this.error = error;
		this.message = message;
		this.data = data;
	}

}
