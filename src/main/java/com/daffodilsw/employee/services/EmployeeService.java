package com.daffodilsw.employee.services;

import java.util.List;
import java.util.Optional;

import com.daffodilsw.employee.models.Employee;
import com.daffodilsw.employee.to.EmployeeTO;


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
	public Employee saveEmployee(EmployeeTO employee);
	
	/**
	 * Find employee by id.
	 *
	 * @param id the id
	 * @return the employee object
	 */
	public Optional<Employee> findEmployeeById(Integer id);
	
	/**
	 * Update employee instance into db and returns the updated instant
	 *
	 * @param employee the employee
	 * @return the employee object
	 */
	public Employee updateEmployee(Integer id, EmployeeTO employee);
}
