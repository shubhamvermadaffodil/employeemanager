package com.daffodilsw.employee.services;

import java.util.List;
import java.util.Optional;

import com.daffodilsw.employee.models.Department;
import com.daffodilsw.employee.to.DepartmentTO;

/**
 * The Interface DepartmentService.
 */
public interface DepartmentService{
	
	/**
	 * Find all departments.
	 *
	 * @return the list
	 */
	public List<Department> findAllDepartments();
	
	/**
	 * Save department.
	 *
	 * @param department the department
	 * @return the department
	 */
	public Department saveDepartment(DepartmentTO department);
	
	/**
	 * Find department by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Department> findDepartmentById(Integer id);
	
	/**
	 * Update department.
	 *
	 * @param id the id
	 * @param department the department
	 * @return the department
	 */
	public Department updateDepartment(Integer id, DepartmentTO department);
}
