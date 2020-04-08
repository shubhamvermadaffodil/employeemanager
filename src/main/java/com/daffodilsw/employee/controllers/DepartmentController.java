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

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	@GetMapping(Constants.URL_DEPRTMENTS)
	public ResponseEntity<List<Department>> getDepartments(){
		List<Department> departments = departmentService.findAllDepartments();
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
	}
	
	@GetMapping(Constants.URL_DEPRTMENTS+"/{id}")
	public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable Integer id){
		Optional<Department> department = departmentService.findDepartmentById(id);
		HttpStatus status = HttpStatus.OK;
		if(!department.isPresent()) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Optional<Department>>(department,status);
	}
	
	@PostMapping(Constants.URL_DEPRTMENTS)
	public @ResponseBody ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
		return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.OK); 
	}
	@PutMapping(Constants.URL_DEPRTMENTS+"/{id}")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable Integer id){
		Department departmentData= departmentService.updateDepartment(id, department);
		return new ResponseEntity<Department>(departmentData,HttpStatus.OK);
	}
}
