package com.cg.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
-File Name          : LoanSchemeNotFoundException
-Author Name        : Capgemini
-Description        : Exception handling for LoanSchemeNotFoundException 
-Creation Date		: 15/04/2021
*/
public class LoanSchemeNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoanSchemeNotFoundException.class);

	public LoanSchemeNotFoundException() {
		
	}
	
	public LoanSchemeNotFoundException(String msg) {
		
		super(msg);
		logger.info("Inside LoanSchemeNotFoundException");
	}

}
