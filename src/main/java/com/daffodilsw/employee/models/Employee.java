package com.daffodilsw.employee.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.daffodilsw.employee.constants.Constants;


/**
 * The Class Employee.
 */
@Entity
@Table(name=Constants.EMPLOYEES)
public class Employee {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The employee department. */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
	private List<EmployeeDepartment> employeeDepartments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<EmployeeDepartment> getEmployeeDepartments() {
		return employeeDepartments;
	}

	public void setEmployeeDepartments(List<EmployeeDepartment> employeeDepartments) {
		this.employeeDepartments = employeeDepartments;
	}
	
	
	
	
}
