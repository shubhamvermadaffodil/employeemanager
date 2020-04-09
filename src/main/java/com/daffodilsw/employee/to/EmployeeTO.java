package com.daffodilsw.employee.to;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.daffodilsw.employee.models.EmployeeDepartment;

/**
 * The Class EmployeeTO.
 */
public class EmployeeTO {
	
	/** The first name. */
	@NotBlank(message = "firstName is mandatory")
	@NotNull(message = "firstName should not be null")
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The deparment. */
	private List<Integer> department;
	
	public List<Integer> getDepartment() {
		return department;
	}

	public void setDepartment(List<Integer> department) {
		this.department = department;
	}

	/**
	 * Instantiates a new employee TO.
	 */
	public EmployeeTO() {
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
