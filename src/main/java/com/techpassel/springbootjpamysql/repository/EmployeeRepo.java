package com.techpassel.springbootjpamysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpassel.springbootjpamysql.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
}
