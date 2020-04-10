package com.daffodilsw.employee.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * The Class DepartmentTO. Transfer object
 */
public class DepartmentTO {

	
	/** The name. */
	@NotBlank(message = "name  is mandatory")
	@NotNull(message = "name should not be null")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
