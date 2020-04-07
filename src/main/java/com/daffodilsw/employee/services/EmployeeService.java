package com.daffodilsw.employee.services;

import java.util.List;

import com.daffodilsw.employee.models.Employee;


/**
 * The Interface EmployeeService.
 */
public interface EmployeeService {
	
	/**
	 * Find all employees.
	 *
	 * @return the list of employees
	 */
	public List<Employee> findAllEmployees();

	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 * @return the employee object
	 */
	public Employee saveEmployee(Employee employee);
	
	/**
	 * Find employee by id.
	 *
	 * @param id the id
	 * @return the employee object
	 */
	public Employee findEmployeeById(Integer id);
	
}
