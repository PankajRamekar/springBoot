package com.te.learnspringbootjpa.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GeneralResponse {

	private String uri;
	private HttpStatus httpStatus;
	private String message;
	private String error;
	private LocalDateTime timeStamp = LocalDateTime.now();
	private Object object;

	public GeneralResponse(String uri, HttpStatus httpStatus, String message, String error, Object object) {
		super();
		this.uri = uri;
		this.httpStatus = httpStatus;
		this.message = message;
		this.error = error;
		this.object = object;
	}

}
