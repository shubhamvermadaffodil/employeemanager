package com.daffodilsw.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daffodilsw.employee.models.Employee;



/**
 * The Interface EmployeeRepository for JPA repositories operations. This must be operated from the service layer. 
 * Not from the controller directly.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
}
