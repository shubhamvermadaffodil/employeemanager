package com.daffodilsw.employee.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daffodilsw.employee.exceptions.DepartmentNotFoundException;
import com.daffodilsw.employee.exceptions.EmployeeNotFoundException;
import com.daffodilsw.employee.models.Department;
import com.daffodilsw.employee.models.Employee;
import com.daffodilsw.employee.repositories.DepartmentRepository;
import com.daffodilsw.employee.to.DepartmentTO;


/**
 * The Class DepartmentServiceImpl.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

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
	public Department saveDepartment(DepartmentTO department) {
		
		Department d = modelMapper.map(department, Department.class);	
		return departmentRepository.save(d);
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
	public Department updateDepartment(Integer id, DepartmentTO department) {
		Department d = departmentRepository.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department not found"));
		d.setName(department.getName()!=null?department.getName():d.getName());
		return departmentRepository.save(d);
	}

}
