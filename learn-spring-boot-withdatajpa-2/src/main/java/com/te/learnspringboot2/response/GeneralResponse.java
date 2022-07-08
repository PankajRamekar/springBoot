
package com.te.learnspringboot2.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class GeneralResponse {

	private String uri;
	private HttpStatus httpStatus;
	private String error;
	private String message;
	private LocalDateTime timestamp = LocalDateTime.now();
	private Object data;

	public GeneralResponse(String uri, HttpStatus httpStatus, String error, String message, Object data) {
		super();
		this.uri = uri;
		this.httpStatus = httpStatus;
		this.error = error;
		this.message = message;
		this.data = data;
	}

}
