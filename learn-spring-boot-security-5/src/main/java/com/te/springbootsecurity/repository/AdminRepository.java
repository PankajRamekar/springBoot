package com.te.springbootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springbootsecurity.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

}
