package com.te.springbootsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springbootsecurity.entity.AppUser;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String>{
	
	AppUser save(AppUser appUser);

	Optional<AppUser> findByUser(String username);

	
}
