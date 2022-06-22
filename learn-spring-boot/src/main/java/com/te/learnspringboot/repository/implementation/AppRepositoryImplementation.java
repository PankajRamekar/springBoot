package com.te.learnspringboot.repository.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.learnspringboot.entity.Employee;
import com.te.learnspringboot.repository.AppRepository;
@Repository
public class AppRepositoryImplementation implements AppRepository {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_for_Springboot");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public Employee getEmployee(int employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		return employee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
	Employee saveEmployee = saveEmployee(employee);
		return saveEmployee;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Employee employee = getEmployee(employeeId);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		return true;
	}

}
