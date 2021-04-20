package com.cg.controllers;
/**
-File Name          : LAD Controller

-Author Name        : Capgemini
-Description        : Rest Controller for LAD Service
-Creation Date		: 15/04/2021
*/

import java.io.Serializable;



import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.LoanRequest;
import com.cg.exceptions.LoanRequestNotFoundException;

import com.cg.services.LoanRequestService;

import io.swagger.annotations.Api;

//@Api(tags={"Opearations Perform by Loan Aproval Department"})
@Api(description = "Opearations Perform by Loan Aproval Department")
@RestController()
@RequestMapping("/lad")
@Validated
public class LadController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static final Logger logger = LoggerFactory.getLogger(LadController.class);
	
	
	@Autowired
	LoanRequestService requestservice;
	
	
	/*******************************************************************************
	 - Method Name      : verifyLoanRequest
	 - Input Parameters : LoanRequest request
	 - Return type      : Customer
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Verifying the Loan Request of Customer
	  ******************************************************************************/
	
	@PutMapping("/verifyloanrequest")
	public String verifyLoanRequest(@Valid @RequestBody LoanRequest request){
		return requestservice.verifyLoanRequest(request);	
		
	}
	
	
	/*******************************************************************************
	 - Method Name      : getRequestById
	 - Input Parameters : Integer id
	 - Return type      : LoanRequest
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Retrieving loan request by id
	  ******************************************************************************/
	@GetMapping("/getloanrequestbyid/{id}")
	public LoanRequest getRequestById(@PathVariable Integer id) throws LoanRequestNotFoundException {
		
		LoanRequest req = null;
		try{
			logger.info("LoanRequest Id to be searched..."+id);
			req = requestservice.getRequestById(id);
		}catch(Exception e) {
			
			throw new LoanRequestNotFoundException("Enter valid LoanRequest id ");
		}
		
		return req;
	}
	
	
	/*******************************************************************************
	 - Method Name      : viewAllLoanRequests
	 - Input Parameters : None
	 - Return type      : List<LoanRequest>
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Retrieving all loan requests
	  ******************************************************************************/
	@GetMapping("/viewallrequests")
	public List<LoanRequest> viewAllLoanRequests(){
		return requestservice.viewAllLoanRequests();
	}
	
	
	/*******************************************************************************
	 - Method Name      : createRequest
	 - Input Parameters : LoanRequest request
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Creating a Loan Request
	  ******************************************************************************/
	
	@PostMapping("/createrequest")
	public String createRequest(@RequestBody LoanRequest request) {
		return requestservice.addloanRequest(request);
		
	}

}
