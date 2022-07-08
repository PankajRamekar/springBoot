package com.te.learnspringsecurity.entity.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class MentorDto {
	
	private String mentorId;
	private String mentorName;
	private String mentorEmail;

}
