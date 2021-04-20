package com.cg.exceptions;

/**
-File Name          : GlobalAdminExceptionHandler
-Author Name        : Capgemini
-Description        : Class for handling Global Exception
-Creation Date		: 15/04/2021
*/
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalAdminExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalAdminExceptionHandler.class);
	
	
	
	/*******************************************************************************
	 - Method Name      : handleLoanSchemeNotFoundException
	 - Input Parameters : LoanSchemeNotFoundException e, HttpServletRequest request
	 - Return type      : ErrorInfo
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : handling LoanSchemeNotFoundException
	  ******************************************************************************/ 
	@ExceptionHandler(LoanSchemeNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo handleLoanSchemeNotFoundException(LoanSchemeNotFoundException e, HttpServletRequest request) {
		
		logger.info("In controller advice to find the AdminId");
		
		ErrorInfo error = new ErrorInfo();    // create instance of ErrorInfo
		error.setUrl(request.getRequestURI());   
		error.setMessage(e.getMessage()); 
		
		return error;
	}
	
	
	
}

