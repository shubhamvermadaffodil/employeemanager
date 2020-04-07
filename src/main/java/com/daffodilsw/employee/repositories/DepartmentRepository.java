package com.daffodilsw.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daffodilsw.employee.models.Department;

/**
 * The Interface DepartmentRepository for JPA repositories operations. This must be operated from the service layer. 
 * Not from the controller directly..
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
}
