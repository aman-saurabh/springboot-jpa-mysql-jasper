package com.techpassel.springbootjpamysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "blog")
public class BlogPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(max = 32)
	private String title;
	
	// Use this if you want to make type of "description" field as "Text"
	// @Column(columnDefinition = "TEXT")
	// private String description;
	
	// Use this if you want to make type of "description" field as "Longtext"
	@Lob
	@NotNull
	private String description;
	
	@ManyToOne
    @JoinColumn(name="emp_details_id", nullable=false)
    private EmployeeDetails empDetails;

	public BlogPost() {
		super();
	}

	public BlogPost(@Size(max = 32) String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EmployeeDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmployeeDetails empDetails) {
		this.empDetails = empDetails;
	}
		
}
