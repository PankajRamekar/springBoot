package com.te.learnspringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learnspringsecurity.entity.Mentor;
@Repository
public interface MentorRepository extends JpaRepository<Mentor, String>{

}
