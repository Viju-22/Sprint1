package com.cg.exceptions;

/**
-File Name          : AbcBankGlobalExceptionHandler
-Author Name        : Capgemini
-Description        : Class for handling Global Exception
-Creation Date		: 15/04/2021
*/

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AbcBankGlobalExceptionHandler {
	
	/*******************************************************************************
	 - Method Name      : handleLoanRequestNotFoundException
	 - Input Parameters : LoanRequestNotFoundException e, HttpServletRequest request
	 - Return type      : ErrorInfo
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : handling LoanRequestNotFoundException
	  ******************************************************************************/ 

    @ExceptionHandler(LoanRequestNotFoundException.class)
    @ResponseStatus( value = HttpStatus.NOT_FOUND)
    @ResponseBody
	public ErrorInfo handleLoanRequestNotFoundException(LoanRequestNotFoundException e, HttpServletRequest request) {
		
		System.out.println("In Controller advice to find the requestId");
		
		ErrorInfo error = new ErrorInfo();
		error.setUrl(request.getRequestURI());
		error.setMessage(e.getMessage());
		return error;	

	}
    

}
