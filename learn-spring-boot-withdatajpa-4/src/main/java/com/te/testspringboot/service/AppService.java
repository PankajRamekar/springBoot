package com.te.testspringboot.service;

import com.te.testspringboot.entity.dto.PersonDto;

public interface AppService {

	PersonDto getPerson(String personId);

	PersonDto registerPerson(PersonDto personDto);

	PersonDto updatePerson(PersonDto personDto);

	Boolean deletePerson(String personId);

}
