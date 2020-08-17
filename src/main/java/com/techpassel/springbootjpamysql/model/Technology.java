package com.techpassel.springbootjpamysql.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "technology")
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(max = 25)
	@Column(name = "tech_name", unique = true)
	private String technology;
	
	public Technology() {
		super();
	}

	public Technology(@NotNull @Size(max = 25) String technology) {
		super();
		this.technology = technology;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "technologies")
    private List<EmployeeDetails> empDetails = new ArrayList<EmployeeDetails>();
	// mappedBy = "technologies" -> This is telling Technology entity is not responsible(i.e not the owner) for this relationship.You should check for "technologies" property in EmployeeDetails Entity for configurations 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public List<EmployeeDetails> getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(List<EmployeeDetails> empDetails) {
		this.empDetails = empDetails;
	}
	
	//To add new EmployeeDetails object in empDetails property and also to add Current Objevt of Technology(i.e 'this') to the passed employeeDetails Object.
	public void addEmployeeDetails(EmployeeDetails employeeDetails) {
		System.out.println("Inside Technology : "+this.technology);
		empDetails.add(employeeDetails);
		employeeDetails.getTechnologies().add(this);
    }
	
}
