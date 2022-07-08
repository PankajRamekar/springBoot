package com.te.learnspringsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learnspringsecurity.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
	
	public Optional<AppUser> findByUsername(String username) ;

}
