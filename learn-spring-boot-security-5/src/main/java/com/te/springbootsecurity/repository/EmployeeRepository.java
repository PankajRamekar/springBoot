package com.te.springbootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springbootsecurity.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

	Employee save(Employee employee);
	
	Employee findByemployeeId(String Id);

}
