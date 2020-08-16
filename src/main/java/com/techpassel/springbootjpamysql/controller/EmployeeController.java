package com.techpassel.springbootjpamysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpassel.springbootjpamysql.model.Employee;
import com.techpassel.springbootjpamysql.model.EmployeeDetails;
import com.techpassel.springbootjpamysql.repository.EmployeeDetailsRepo;
import com.techpassel.springbootjpamysql.repository.EmployeeRepo;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	EmployeeDetailsRepo empDetailsRepo;
	
	@RequestMapping("/employees")
	public ModelAndView emp() {
		List<Employee> el = empRepo.findAll();
		System.out.println(el);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("emplist");
		mv.addObject("emplist", el);
		return mv;
	}
	
	@RequestMapping("add-employee")
	public String addEmployee() {
		Employee employee = new Employee("Saurabh","saurabh@gmail.com");
		EmployeeDetails empDetails = new EmployeeDetails("Noida","Senior Developer",55000);
		
		// Set child reference(userProfile) in parent entity(user)
		employee.setEmpdetails(empDetails);
		// Set parent reference(user) in child entity(userProfile)
		empDetails.setEmploy(employee);
		
		// Save Parent Reference (which will save the child as well)
        empRepo.save(employee);
		System.out.println("Employee Added Successfully");
		return "Employee added successfully";
	}
}
