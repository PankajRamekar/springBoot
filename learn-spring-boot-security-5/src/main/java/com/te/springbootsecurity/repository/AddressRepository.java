package com.te.springbootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springbootsecurity.entity.Address;
import com.te.springbootsecurity.entity.Employee;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
