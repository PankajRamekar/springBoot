package com.te.learnspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learnspringsecurity.entity.Roles;
@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
