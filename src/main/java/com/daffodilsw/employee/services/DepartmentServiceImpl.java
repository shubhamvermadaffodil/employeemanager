package com.daffodilsw.employee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daffodilsw.employee.models.Department;
import com.daffodilsw.employee.repositories.DepartmentRepository;


/**
 * The Class DepartmentServiceImpl.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	/**
	 * Find all departments.
	 *
	 * @return the list
	 */
	@Override
	public List<Department> findAllDepartments() {
		
		return departmentRepository.findAll();
	}

	/**
	 * Save department.
	 *
	 * @param department the department
	 * @return the department
	 */
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	/**
	 * Find department by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	@Override
	public Optional<Department> findDepartmentById(Integer id) {
		return departmentRepository.findById(id);
	}

	/**
	 * Update department.
	 *
	 * @param id the id
	 * @param department the department
	 * @return the department
	 */
	@Override
	public Department updateDepartment(Integer id, Department department) {
		department.setId(id);
		return departmentRepository.save(department);
	}

}
