package com.te.learnspringboot2.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.te.learnspringboot2.entity.enums.BloodGroup;
import com.te.learnspringboot2.entity.enums.Degree;
import com.te.learnspringboot2.entity.enums.EmployeeStatus;
import com.te.learnspringboot2.entity.enums.Gender;
import com.te.learnspringboot2.entity.enums.Nationality;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee_info")
public class Employee {
	@Id
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private LocalDate employeeDateOfBirth;
	private LocalDate employeeDateOfJoining;
	private LocalDateTime employeeLastLogin;
	private String employeeDesignation;

	@Enumerated(EnumType.STRING)
	private Nationality employeeNationality;
	@Enumerated(EnumType.STRING)
	private Gender employeeGender;
	@Enumerated(EnumType.STRING)
	private BloodGroup employeeBloodGroup;
	@Enumerated(EnumType.STRING)
	private Degree employeeDegree;
	@Enumerated(EnumType.STRING)
	private EmployeeStatus employeeEmployeeStatus;

	@OneToMany(cascade = CascadeType.ALL)
	private List<EmployeeAddress> employeeAddress;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_FK")
	private Batch batch;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Attendance> attendance;

}
