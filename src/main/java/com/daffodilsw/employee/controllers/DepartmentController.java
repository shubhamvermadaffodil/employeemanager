package com.daffodilsw.employee.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daffodilsw.employee.constants.Constants;
import com.daffodilsw.employee.models.Department;
import com.daffodilsw.employee.services.DepartmentService;

/**
 * The Class DepartmentController handling REST routes for departments
 */
@RestController
public class DepartmentController {

	/** The department service. */
	@Autowired
	private DepartmentService departmentService;

	/**
	 * Gets the departments.
	 *
	 * @return the departments
	 */
	@GetMapping(Constants.URL_DEPRTMENTS)
	public ResponseEntity<List<Department>> getDepartments() {
		List<Department> departments = departmentService.findAllDepartments();
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
	}

	/**
	 * Gets the department by id.
	 *
	 * @param id the id
	 * @return the department by id
	 */
	@GetMapping(Constants.URL_DEPRTMENTS + "/{id}")
	public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable Integer id) {
		Optional<Department> department = departmentService.findDepartmentById(id);
		HttpStatus status = HttpStatus.OK;
		if (!department.isPresent()) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Optional<Department>>(department, status);
	}

	/**
	 * Save department.
	 *
	 * @param department the department
	 * @return the response entity
	 */
	@PostMapping(Constants.URL_DEPRTMENTS)
	public @ResponseBody ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
		return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.OK);
	}

	/**
	 * Update department.
	 *
	 * @param department the department
	 * @param id         the id
	 * @return the response entity
	 */
	@PutMapping(Constants.URL_DEPRTMENTS + "/{id}")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable Integer id) {
		Department departmentData = departmentService.updateDepartment(id, department);
		return new ResponseEntity<Department>(departmentData, HttpStatus.OK);
	}
}
