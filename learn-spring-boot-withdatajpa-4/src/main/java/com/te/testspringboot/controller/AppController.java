package com.te.testspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.te.testspringboot.entity.dto.PersonDto;
import com.te.testspringboot.response.GeneralResponse;
import com.te.testspringboot.service.AppService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class AppController {

	private final AppService appService;

	@GetMapping("/person/{personId}")
	public ResponseEntity<GeneralResponse> getPersonInfo(@PathVariable String personId) {
		PersonDto personDto = appService.getPerson(personId);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "error", "message", personDto));
	}

	@PostMapping(path = "/register")
	public ResponseEntity<GeneralResponse> registerPerson(@RequestBody PersonDto personDto) {

		PersonDto personDto2 = appService.registerPerson(personDto);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "error", "message", personDto2));
	}

	
	@PutMapping(path = "/update/{personId}")
	public ResponseEntity<GeneralResponse> updatePerson(@RequestBody PersonDto personDto) {
		PersonDto updateddto = appService.updatePerson(personDto);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "error", "message", updateddto));
	}

	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<GeneralResponse> deletePerson(@PathVariable String personId) {
		Boolean isDeleted = appService.deletePerson(personId);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, "error", "message", isDeleted));
	}
}
