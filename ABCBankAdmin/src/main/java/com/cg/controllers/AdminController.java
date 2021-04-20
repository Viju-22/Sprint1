package com.cg.controllers;
/**
-File Name          : Admin Controller
-Author Name        : Capgemini
-Description        : Rest Controller for Admin Service
-Creation Date		: 15/04/2021
*/
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.LoanScheme;
import com.cg.exceptions.LoanSchemeNotFoundException;
import com.cg.services.LoanSchemeService;

import io.swagger.annotations.Api;

@Api
@RestController()
@RequestMapping("/admin")
@Validated
public class AdminController {
    
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	LoanSchemeService loanschemeservice;
	
	

	/*******************************************************************************
	 - Method Name      : addLoanScheme
	 - Input Parameters : LoanScheme l
	 - Return type      : LoanScheme
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Adding a loan scheme to database
	  ******************************************************************************/
	@PostMapping("/addscheme")
	public LoanScheme addLoanScheme(@Valid @RequestBody LoanScheme l){
		
		return loanschemeservice.addLoanScheme(l);
		
	}
	
	
	
	/*******************************************************************************
	 - Method Name      : updateLoanScheme
	 - Input Parameters : LoanScheme l
	 - Return type      : LoanScheme
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Updating a loan scheme in database
	  ******************************************************************************/
	@PutMapping("/updatescheme")
	public LoanScheme updateLoanScheme(@Valid @RequestBody LoanScheme l){
		
		return loanschemeservice.updateLoanScheme(l);
		
	}
	
	
	
	/*******************************************************************************
	 - Method Name      : getLoanSchemeById
	 - Input Parameters : Integer id
	 - Return type      : LoanScheme
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Retrieving a loan scheme by Id
	  ******************************************************************************/
	@GetMapping(value="/getschemebyid/{id}")
	public LoanScheme getLoanSchemeById(@PathVariable Integer id) throws LoanSchemeNotFoundException {
		logger.info("In Admin Controller to retrieve a Loan Scheme by Id ..>!!!");
		 
		LoanScheme l = null;
		try{
			logger.info("LoanScheme Id to be searched..."+id);
			l = loanschemeservice.getSchemeById(id);
		}catch(Exception e) {
			
			throw new LoanSchemeNotFoundException("Enter valid LoanScheme id ");
		}
		
		return l;
	}
	
	
	
	/*******************************************************************************
	 - Method Name      : deleteLoanScheme
	 - Input Parameters : Integer id
	 - Return type      : Boolean
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Deleting a loan scheme from database
	  ******************************************************************************/
	@DeleteMapping("/deletescheme/{id}")
	public Boolean deleteLoanScheme(@PathVariable Integer id) throws LoanSchemeNotFoundException{
		
		logger.info("In Admin Controller to delete LoanScheme by Id ..>!!!");
		
	
		try{
			logger.info("LoanScheme Id to be deleted..."+id);
			
			loanschemeservice.getSchemeById(id);
		}catch(Exception e) {
			logger.info("In catch block of DeleteAdminById() ...!");
			throw new LoanSchemeNotFoundException("Enter an existing  LoanRequest id to be deleted  ");
		}
		
		return loanschemeservice.deleteLoanScheme(id);
		
	}
	
	

	/*******************************************************************************
	 - Method Name      : deleteLoanScheme
	 - Input Parameters : None
	 - Return type      : List<LoanScheme>
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Retrieving a list of Loan schemes from database
	  ******************************************************************************/
	
	@GetMapping("/viewallscheme")
	public List<LoanScheme> viewAllLoanSchemes(){
		return loanschemeservice.viewAllScheme();
	}
	
	
}
