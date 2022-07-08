package com.te.learnspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learnspringsecurity.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
