package com.te.learnspringboot3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learnspringboot3.response.GeneralResponse;

@RestController
@RequestMapping(path = "/api")
public class Controller {

	@GetMapping(path = "/student")
	public ResponseEntity<GeneralResponse> getStudent() {
		return null;
		
	}
	
}
