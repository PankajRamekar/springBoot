package com.te.testspringboot.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.te.testspringboot.entity.Person;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppRepositoryTest {
	
	@Autowired
	private AppRepository appRepository;
	
	@Test
	public void crud_basicTest() {
		
		Person person= new Person();
		person.setPersonId("P01");
		person.setPersonName("name01");
		person.setPersonAge(24);
		person.setPersonEmail("email");
		
		appRepository.save(person);
		
		Optional<Person> optional= appRepository.findById("P01");
		Person personDb = optional.get();
		
		assertThat(personDb).isNotNull();
		assertEquals(person.getPersonName(), personDb.getPersonName());
		
		appRepository.deleteAll();
		
		List<Person> findAll = appRepository.findAll();
		assertThat(findAll).isEmpty();
	}
	
	
}
