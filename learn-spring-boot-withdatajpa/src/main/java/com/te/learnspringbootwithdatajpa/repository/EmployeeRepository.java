package com.te.learnspringbootwithdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learnspringbootwithdatajpa.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
