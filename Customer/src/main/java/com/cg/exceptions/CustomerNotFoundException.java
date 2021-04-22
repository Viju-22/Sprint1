package com.cg.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
-File Name          : CustomerNotFoundException

-Author Name        : Capgemini
-Description        : Exception handling for CustomerNotFoundException 
-Creation Date		: 15/04/2021
*/

public class CustomerNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerNotFoundException.class);

	public CustomerNotFoundException() {
		
	}
	
	public CustomerNotFoundException(String message) {
		super(message);
		logger.info("Inside CustomerNotFoundException");
	}

}
