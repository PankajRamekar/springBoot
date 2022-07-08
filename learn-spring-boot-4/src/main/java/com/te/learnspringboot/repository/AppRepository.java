package com.te.learnspringboot.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.learnspringboot.entity.Employee;

@Repository
public class AppRepository {
	

	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("PUForSB");
	EntityManager entityManager= entityManagerFactory.createEntityManager();

	public Employee findEmployee(int empId) {
		Employee employee = entityManager.find(Employee.class, empId);
		return employee ;
	}

	public Employee saveEmployee(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
		return employee;
	}

	public Boolean removeEmployee(int empId) {
		Employee employee = findEmployee(empId);
		entityManager.remove(employee);
		return true;
	}

}
