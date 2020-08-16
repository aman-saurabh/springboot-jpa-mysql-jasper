package com.techpassel.springbootjpamysql.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "emp_details")
public class EmployeeDetails implements Serializable{
	private static final long serialVersionUID = 2742227390645621450L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
	
}
