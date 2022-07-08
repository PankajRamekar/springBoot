package com.te.testspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.testspringboot.entity.Person;

@Repository
public interface AppRepository extends JpaRepository<Person, String> {

}
