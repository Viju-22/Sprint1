package com.cg.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
-File Name          : LoanRequestNotFoundException
-Author Name        : Capgemini
-Description        : Exception handling for LoanRequestNotFoundException 
-Creation Date		: 15/04/2021
*/
public class LoanRequestNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoanRequestNotFoundException.class);
	
	public LoanRequestNotFoundException() {
		
	}
	
	public LoanRequestNotFoundException(String message) {
		super(message);
		logger.info("Inside LoanRequestNotFoundException");
	
	}

}
