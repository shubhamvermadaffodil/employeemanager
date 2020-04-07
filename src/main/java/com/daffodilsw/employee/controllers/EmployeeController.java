package com.daffodilsw.employee.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daffodilsw.employee.constants.Constants;
import com.daffodilsw.employee.models.Employee;
import com.daffodilsw.employee.services.EmployeeService;


/**
 * The Class EmployeeController.
 */
@RestController
public class EmployeeController {
	 
	/** The employee service. */
	@Autowired
	private EmployeeService empService;
	
	/**
	 * Gets the employees List from database.
	 *
	 * @return the employees
	 */
	@GetMapping(Constants.URL_EMPLOYEES)
	public ResponseEntity<List<Employee>>  getEmployees(){
		List<Employee> employees = empService.findAllEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	/**
	 * Save user to the database.
	 *
	 * @param employee the employee
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@PostMapping(Constants.URL_EMPLOYEES)
	public @ResponseBody ResponseEntity<Employee> saveUser(@Valid @RequestBody Employee employee) throws Exception {
//		TODO: Integrate filter or Intercepter which validate body/params/query if any.
		Employee employeeData = empService.saveEmployee(employee);
		return new ResponseEntity<Employee>(employeeData, HttpStatus.OK);
	}
	
	/**
	 * Gets the employee by id.
	 *
	 * @param id the id
	 * @return the employee object for provided id.
	 */
	@GetMapping(Constants.URL_EMPLOYEES+"/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		Employee employee = empService.findEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK); 
	}
	
}
