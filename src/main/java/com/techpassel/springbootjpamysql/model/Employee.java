package com.techpassel.springbootjpamysql.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "employee")
public class Employee {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	@NotNull
	@Size(max = 25)
	@Column(name = "emp_name")
	private String empName;
	//To link emp_id field in the table to property empId.
	//If you don't want to use it then you have to keep table field name same as property name.
	
	@NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;
	
	@Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employ")
	private EmployeeDetails empdetails;
	//fetch = FetchType.LAZY - Fetch the related entity lazily from the database.
	//cascade = CascadeType.ALL -> Whenever we update/delete a Employee entity, update/delete the corresponding EmployeeDetails as well
	//mappedBy = "employ" -> To tell hibernate that the Employee entity is not responsible(i.e owner) for this relationship and It should look for a field named "employ" in the EmployeeDetails entity to find the configuration for the Join Column/ForeignKey Column
	//We can make any of the entity as owner.In this case we have made EmployeeDetails Entity as owner and simply passed the responsibility to that by using "mappedBy" attribute.
	
	public Employee() {
		super();
	}

	public Employee(@NotNull @Size(max = 25) String empName, @NotNull @Email @Size(max = 100) String email) {
		super();
		this.empName = empName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public EmployeeDetails getEmpdetails() {
		return empdetails;
	}

	public void setEmpdetails(EmployeeDetails empdetails) {
		this.empdetails = empdetails;
	}

}
