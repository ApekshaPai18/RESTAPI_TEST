package com.example.restservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.entities.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>{
	
	

}
