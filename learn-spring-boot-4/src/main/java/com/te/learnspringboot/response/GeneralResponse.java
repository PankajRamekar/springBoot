package com.te.learnspringboot.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class GeneralResponse {

	private HttpStatus httpStatus;
	private String message;
	private String error;
	private LocalDateTime timeStamp = LocalDateTime.now();
	private Object data;

	public GeneralResponse(HttpStatus httpStatus, String message, String error, Object data) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.error = error;
		this.data = data;
	}

}
