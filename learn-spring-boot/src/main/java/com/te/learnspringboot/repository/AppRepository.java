package com.te.learnspringboot.repository;

import org.springframework.stereotype.Repository;

import com.te.learnspringboot.entity.Employee;
@Repository
public interface AppRepository {

	public abstract Employee getEmployee(int employeeId);

	public abstract Employee saveEmployee(Employee employee);

	public abstract Employee updateEmployee(int employeeId, Employee employee);

	public abstract boolean deleteEmployee(int employeeId);
}
