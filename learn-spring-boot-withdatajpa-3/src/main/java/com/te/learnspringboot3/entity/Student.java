package com.te.learnspringboot3.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Student {
	@Id
	private String studentId;
	private String studentName;
	private int studentAge;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<StudentAddress>  studentAddress;
}
