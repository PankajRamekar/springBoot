package com.te.testspringboot.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.te.testspringboot.entity.dto.PersonDto;

public class AppServiceTest {
	

	private AppService appService = mock(AppService.class);
	
	@Test
	public void getPerson_basicTest() {
		
		PersonDto personDto= new PersonDto("P01","Pankaj",24,"Email");
		when(appService.getPerson("P01")).thenReturn(personDto);
		PersonDto person = appService.getPerson("P01");
		assertThat(person).isNotNull();
		assertEquals(personDto.getPersonName(), person.getPersonName());
		
	}
	
	public void registerPerson_basicTest() {
		PersonDto personDto = new PersonDto("P01","Pankaj",24,"Email");
		when(appService.registerPerson(personDto)).thenReturn(personDto);
		
		PersonDto registerPerson = appService.registerPerson(personDto);
		assertThat(registerPerson).isNotNull();
		assertEquals(personDto.getPersonAge(), registerPerson.getPersonAge());
	}
}
