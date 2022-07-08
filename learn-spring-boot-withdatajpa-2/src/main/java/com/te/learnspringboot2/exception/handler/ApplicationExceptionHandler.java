package com.te.learnspringboot2.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.learnspringboot2.exception.EmployeeNotFoundException;
import com.te.learnspringboot2.response.GeneralResponse;

@ControllerAdvice
public class ApplicationExceptionHandler {

		@ExceptionHandler(value = {EmployeeNotFoundException.class})
		public ResponseEntity<GeneralResponse> handler(EmployeeNotFoundException e) {
			return ResponseEntity.badRequest().body(new GeneralResponse(null, HttpStatus.BAD_REQUEST, e.getMessage(), null, null));
			
		}
		@ExceptionHandler(value = {NullPointerException.class})
		public ResponseEntity<GeneralResponse> handler(NullPointerException e){
			return ResponseEntity.badRequest().body(new GeneralResponse(null, HttpStatus.BAD_REQUEST, "something went wrong!", null, null));
			
		}
}
