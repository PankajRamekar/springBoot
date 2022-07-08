package com.te.learnspringboot3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.te.learnspringboot3.entity.enums.AddressType;
@Entity
public class StudentAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer AddressId;
	private String locality;
	private AddressType addressType;
}
