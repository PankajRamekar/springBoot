package com.te.learnspringbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.learnspringbootjpa.entity.Employee;



public interface AppRepository extends JpaRepository<Employee, Integer>{

	

}
