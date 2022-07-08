package com.te.learnspringboot2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learnspringboot2.entity.Employee;
@Repository
public interface EmpRepository extends JpaRepository<Employee, String> {
	
	Optional<Employee> findByEmployeeId(String employeeId);
}
