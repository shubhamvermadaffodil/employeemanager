package com.daffodilsw.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daffodilsw.employee.models.Employee;
import com.daffodilsw.employee.repositories.EmployeeRepository;


/**
 * The Class EmployeeService implementations. 
 * Which Should be defined in Service layer to handle the operations from DB 
 * to controller and controller to DB.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	/**  The employee repository autowire to the implemented methods from the EmployeeRepository interface from JPA. */
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	/**
	 * Implementation of  findAll function from EmployeeService interface.
	 *
	 * @return the list
	 */
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	/**
	 * Save employee to the database.
	 *
	 * @param employee the employee
	 * @return the employee
	 */
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	/**
	 * Find employee by id.
	 *
	 * @param id the id
	 * @return the employee
	 */
	public Employee findEmployeeById(Integer id){
		return employeeRepository.getOne(id);
	}

}
