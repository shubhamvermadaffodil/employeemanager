package com.daffodilsw.employee.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.daffodilsw.employee.exceptions.EmployeeNotFoundException;
import com.daffodilsw.employee.models.Department;
import com.daffodilsw.employee.models.Employee;
import com.daffodilsw.employee.models.EmployeeDepartment;
import com.daffodilsw.employee.repositories.DepartmentRepository;
import com.daffodilsw.employee.repositories.EmployeeDepartmentRepository;
import com.daffodilsw.employee.repositories.EmployeeRepository;
import com.daffodilsw.employee.to.EmployeeTO;


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
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeDepartmentRepository employeeDepartmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
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
	public Employee saveEmployee(EmployeeTO employee) {
	
		Employee emp = modelMapper.map(employee, Employee.class);
		List<EmployeeDepartment> employeeDepartments = new ArrayList<>();
		Employee empDoc = employeeRepository.save(emp);
		
		employee.getDepartment().forEach((d)-> {
			Department dpt = departmentRepository.findById(d).orElseThrow(()->new EmployeeNotFoundException());
			
			EmployeeDepartment empDpt = new EmployeeDepartment();
			empDpt.setDepartment(dpt);
			empDpt.setEmployee(empDoc);
			
			employeeDepartments.add(empDpt);
		});
		employeeDepartmentRepository.saveAll(employeeDepartments);
		return empDoc;
	}

	/**
	 * Find employee by id.
	 *
	 * @param id the id
	 * @return the employee
	 */
	public Optional<Employee> findEmployeeById(Integer id){
		return employeeRepository.findById(id);
	} 
	
	/**
	 * Update employee by id and employeeData need to be updated.
	 * @param id the id
	 * @param employeeData the employeeData
	 * @return the employee object
	 */
	public Employee updateEmployee(Integer id, EmployeeTO employeeData) {
		
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found"));
		
		employee.setFirstName(employeeData.getFirstName()!=null?employeeData.getFirstName():employee.getFirstName());
		employee.setLastName(employeeData.getLastName()!=null?employeeData.getLastName():employee.getLastName());
		
		return employeeRepository.save(employee);
	}

}
