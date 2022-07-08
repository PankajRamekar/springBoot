package com.te.springbootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springbootsecurity.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
