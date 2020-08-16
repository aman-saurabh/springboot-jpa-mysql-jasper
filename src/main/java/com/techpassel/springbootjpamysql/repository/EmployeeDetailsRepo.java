package com.techpassel.springbootjpamysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpassel.springbootjpamysql.model.EmployeeDetails;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Integer>{
	
}
