package com.daffodilsw.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * The Class EmployeeManagerApplication.
 * Start the application which contains @Configuration, @EnableAutoConfiguration @ComponentScan
 */
@SpringBootApplication
public class EmployeeManagerApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);
	}
}
