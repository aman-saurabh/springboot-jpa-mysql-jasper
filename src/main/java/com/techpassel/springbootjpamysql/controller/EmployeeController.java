package com.techpassel.springbootjpamysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpassel.springbootjpamysql.model.BlogPost;
import com.techpassel.springbootjpamysql.model.Employee;
import com.techpassel.springbootjpamysql.model.EmployeeDetails;
import com.techpassel.springbootjpamysql.model.Technology;
import com.techpassel.springbootjpamysql.repository.EmployeeDetailsRepo;
import com.techpassel.springbootjpamysql.repository.EmployeeRepo;
import com.techpassel.springbootjpamysql.repository.TechnologyRepo;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	EmployeeDetailsRepo empDetailsRepo;
	
	@Autowired
	TechnologyRepo techRepo;
	
	@RequestMapping("/employees")
	public ModelAndView emp() {
		List<Employee> el = empRepo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("emplist");
		mv.addObject("emplist", el);
		return mv;
	}
	
	//Call This Method to add Employees.
	@RequestMapping("add-employee")
	public void addEmployee() {
		String name = "Ravi";
		String email = "ravi@gmail.com";
		String location = "Noida";
		String post = "SDE";
		int salary = 40000;
		String[] techNames = {"Python", "NodeJs", "Java", "Ruby"};
		String[][] blogs = {{"Why Java is awesome.", "Blah Blah Blah...."},{"Python, The future of AI.", "Blah Blah Blah...."}};
		
		Employee employee = new Employee(name,email);
		EmployeeDetails empDetails = new EmployeeDetails(location,post,salary);		
		// To set child reference in parent entity - OneToOne
		employee.setEmpdetails(empDetails);
		// To set parent reference in child entity -OneToOne
		empDetails.setEmploy(employee);
		
		List<EmployeeDetails> edl= new ArrayList<EmployeeDetails>();
		edl.add(empDetails);
		
		List<Technology> techs = new ArrayList<Technology>();
		
		List<Technology> allTechs = techRepo.findAll(); 
		for (String s: techNames) {
			Technology tech = new Technology(s);
			tech.setEmpDetails(edl);
			boolean doesExist = allTechs.stream().anyMatch(o -> o.getTechnology().equals(s));
			if(doesExist) {
				//If technology already exists then we won't create new one with same name(even that is not possible also as we have set "technology" field as "unique").So we are modifying its empDetails only.
				Optional<Technology> tc = allTechs.stream().filter(t -> s.equals(t.getTechnology())).findAny();
				if(tc.isPresent()) {
					tech = tc.get();
					tech.addEmployeeDetails(empDetails);
				}
			} 		
			// To set child reference in parent entity - ManyToMany
			techs.add(tech);
		}		
		
		// To set parent reference in child entity -ManyToMany
		empDetails.setTechnologies(techs);
		
		List<BlogPost> bposts = new ArrayList<BlogPost>();
		for (String[] b : blogs) {
			BlogPost bp = new BlogPost(b[0], b[1]);
			// To set child reference in parent entity - ManyToOne
			bp.setEmpDetails(empDetails);
			bposts.add(bp);
		}
		
		empDetails.setBlogpost(bposts);
			
		// Save Parent Reference (which will save the child as well)
		// We can use save method to save new data as well as for modifying existing data.
        empRepo.save(employee);
	}
}