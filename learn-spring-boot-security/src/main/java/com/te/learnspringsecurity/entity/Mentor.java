package com.te.learnspringsecurity.entity;

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

public class Mentor {
	@Id
	private String mentorId;
	private String mentorName;
	private String mentorEmail;
	private String mentorPass;
	private String mentorRole;

	
	@OneToOne
	private AppUser appUser;

}
