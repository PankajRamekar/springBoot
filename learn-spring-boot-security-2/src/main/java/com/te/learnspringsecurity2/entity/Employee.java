package com.te.learnspringsecurity2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
	@Id
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeePass;
	private String EmployeeRole;

	
	@OneToOne
	private AppUser appUser;
}
