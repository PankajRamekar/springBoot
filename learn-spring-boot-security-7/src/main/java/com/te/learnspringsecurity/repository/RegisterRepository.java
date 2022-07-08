package com.te.learnspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springbootsecurity.entity.Employee;
@Repository
public interface RegisterRepository extends JpaRepository<Employee, String>{

	Employee save(Employee employee);

}
