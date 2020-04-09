package com.daffodilsw.employee.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.daffodilsw.employee.constants.Constants;

/**
 * The Class Employee.
 */
@Entity
@Table(name = Constants.EMPLOYEES)
public class Employee {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The employee department. */
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
	name = "employee_department",
	joinColumns = {
			@JoinColumn(name = "employee_id", referencedColumnName = "id")
			}, 
	inverseJoinColumns = {
			@JoinColumn(name = "department_id", referencedColumnName = "id") 
			}
	)
	private List<Department> departments;

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

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
}
