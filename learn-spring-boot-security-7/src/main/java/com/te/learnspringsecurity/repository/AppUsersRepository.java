package com.te.learnspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.springbootsecurity.entity.AppUser;

public interface AppUsersRepository extends JpaRepository<AppUser, String> {
	
	

}
