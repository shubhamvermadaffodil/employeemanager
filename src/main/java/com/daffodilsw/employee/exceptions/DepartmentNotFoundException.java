package com.daffodilsw.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new department not found exception.
	 */
	public DepartmentNotFoundException() {
		super();
	}

	/**
	 * Instantiates a new department not found exception.
	 *
	 * @param message the message
	 */
	public DepartmentNotFoundException(String message) {
		super(message);
	}
	
	
	/**
	 * Instantiates a new department not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
