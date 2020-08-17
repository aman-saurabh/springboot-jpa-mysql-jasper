package com.techpassel.springbootjpamysql.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "emp_details")
public class EmployeeDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Size(max = 32)
	@Column(name = "job_location")
	private String location;
	
	@Size(max = 32)
	private String post;
	
	@Size(max = 32)
	private int salary;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employ;
	//It is used manage relationship with Employee Entity.However it will also create a field "emp_id" in the emp_details table to maintain foreign key. 
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	})
	@JoinTable(
		  name = "emp_tech", 
		  joinColumns = @JoinColumn(name = "emp_details_id"), 
		  inverseJoinColumns = @JoinColumn(name = "tech_id"))
	private List<Technology> technologies = new ArrayList<Technology>();
	// ManyToMany relationship is managed by a third table which we configure with @JoinTable annotation. 
	// Above code will create an extra table "emp_tech" especially to manage relationships between EmployeeDetails and Technology Entities 
		
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="empDetails")
	List<BlogPost> blogpost;
    
	
	public EmployeeDetails() {
		super();
	}

	public EmployeeDetails(@Size(max = 32) String location, @Size(max = 32) String post,
			@Size(max = 10) int salary) {
		super();
		this.location = location;
		this.post = post;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee getEmploy() {
		return employ;
	}

	public void setEmploy(Employee employ) {
		this.employ = employ;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

	public List<BlogPost> getBlogpost() {
		return blogpost;
	}

	public void setBlogpost(List<BlogPost> blogpost) {
		this.blogpost = blogpost;
	}
		
}
