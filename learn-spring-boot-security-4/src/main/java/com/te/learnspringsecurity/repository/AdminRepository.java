package com.te.learnspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learnspringsecurity.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

	
}
