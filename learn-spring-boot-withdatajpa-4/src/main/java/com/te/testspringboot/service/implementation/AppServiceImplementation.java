package com.te.testspringboot.service.implementation;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.testspringboot.entity.Person;
import com.te.testspringboot.entity.dto.PersonDto;
import com.te.testspringboot.repository.AppRepository;
import com.te.testspringboot.service.AppService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AppServiceImplementation implements AppService {
	private final AppRepository appRepository;

	@Override
	public PersonDto getPerson(String personId) {
		// TODO Auto-generated method stub
		PersonDto personDto = new PersonDto();
		Optional<Person> optional = appRepository.findById(personId);
		if(optional.isPresent()) {
			Person person = optional.get();
		
		BeanUtils.copyProperties(person, personDto);
		}
		return personDto;
		
	}

	@Override
	public PersonDto registerPerson(PersonDto personDto) {
		// TODO Auto-generated method stub
		Person person = new Person();
		BeanUtils.copyProperties(personDto, person);
		Person savePerson = appRepository.save(person);
		BeanUtils.copyProperties(savePerson, personDto);
		return personDto;
	}

	@Override
	public PersonDto updatePerson(PersonDto personDto) {
		// TODO Auto-generated method stub
		Optional<Person> optional = appRepository.findById(personDto.getPersonId());
		if (optional.isPresent()) {
			Person person = optional.get();
			BeanUtils.copyProperties(personDto, person);
			person = appRepository.save(person);
			BeanUtils.copyProperties(person, personDto);
			return personDto;
		}
		return null;
	}

	@Override
	public Boolean deletePerson(String personId) {
		Optional<Person> optional = appRepository.findById(personId);
		if (optional.isPresent()) {
			Person person = optional.get(); 
			appRepository.delete(person);
			return true;
		}
		return false;
	}

}
