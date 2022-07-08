package com.te.springbootsecurity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Admin {
	@Id
	private String adminId;
	private String adminName;
	private String adminEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
}
