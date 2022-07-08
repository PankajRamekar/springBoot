package com.te.learnspringboot2.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Batch {
	@Id
	private Integer batchId;
	private String batchName;
	private LocalDate batchStartDate;
	private LocalDate batchEndDate;
	
	@OneToMany(mappedBy = "batch")
	private List<Employee>employee;
}
