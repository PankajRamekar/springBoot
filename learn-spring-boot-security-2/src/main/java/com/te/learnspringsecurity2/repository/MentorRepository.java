package com.te.learnspringsecurity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learnspringsecurity2.entity.Mentor;
@Repository
public interface MentorRepository extends JpaRepository<Mentor, String>{

}
