package com.daffodilsw.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class EmployeeNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418400073875155224L;

	/**
	 * Instantiates a new constructor for employee not found exception.
	 */
	public EmployeeNotFoundException(){
		super();
	}
	
	/**
	 * Instantiates a new constructor for employee not found exception.
	 *
	 * @param message the message
	 */
	public EmployeeNotFoundException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new  constructor for employee  not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
