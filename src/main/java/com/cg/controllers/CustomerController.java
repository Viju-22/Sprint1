package com.cg.controllers;
/**
-File Name          : Customer Controller

-Author Name        : Capgemini
-Description        : Rest Controller for Customer Services
-Creation Date		: 15/04/2021
*/


import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.entities.Customer;
import com.cg.entities.LoanRequest;
import com.cg.exceptions.CustomerNotFoundException;
import com.cg.services.CustomerService;

import io.swagger.annotations.Api;

@Api(description = "API for Customer Operations")
@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService custservice;


		@Autowired
		RestTemplate restTemplate;

	/*******************************************************************************
	 - Method Name      : adCustomer
	 - Input Parameters : Customer c
	 - Return type      : Customer
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Inserting a Customer into the database.
	  ******************************************************************************/
				@PostMapping("/addcustomer")
				public Customer addCustomer(@Valid @RequestBody Customer c) {
					logger.info("In Customer Controller to add a Customer !!!");
					return custservice.addCustomer(c);
			
				}
			
				
	
	/*******************************************************************************
	 - Method Name      : getCustomerbyId
	 - Input Parameters : Integer id
	 - Return type      : Customer
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Retrieving a Customer from the database.
	  ******************************************************************************/
				@GetMapping("/getcustomerbyid/{id}")
				public Customer getCustomerbyId(@PathVariable Integer id) throws CustomerNotFoundException {
					
					logger.info("In Customer Controller to retrieve an Customer by Id ..>!!!");
					 
					Customer cust = null;
					try{
						logger.info("Customer Id to be searched..."+id);
						cust = custservice.getCustomerById(id);
					}catch(Exception e) {
			
						throw new CustomerNotFoundException("Enter valid Customer id ");
					}	
					return cust;
				}

	
	
	/*******************************************************************************
	 - Method Name      : getSchemes
	 - Input Parameters : None
	 - Return type      : ResponseEntity<String>
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Retrieving List of Loan Schemes from Admin
	  ******************************************************************************/
				@GetMapping(value = "/getschemefromadmin")
				public ResponseEntity<String> getSchemes() {
					String schemes = restTemplate.getForObject("http://localhost/admins/admin/viewallscheme", String.class);
					return ResponseEntity.ok(schemes);
				}
	
	

	/*******************************************************************************
	 - Method Name      : viewCustomers
	 - Input Parameters : None
	 - Return type      : List<Customer>
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Retrieve a list of Customers from the database.
	  ******************************************************************************/
				@GetMapping(value="/viewallcustomers")
				public List<Customer> viewCustomers(){
					return custservice.viewAllCustomers();
					
				}
				
	
	
	/*******************************************************************************
	 - Method Name      : checkEmi
	 - Input Parameters : String scheme, double amount, double period
	 - Return type      : double
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Calculate EMI value
	  ******************************************************************************/ 
			@GetMapping(value="/checkemi/{scheme}/{amount}/{period}")
			public double checkEmi(@PathVariable String scheme,@PathVariable double amount,@PathVariable double period) {
				return custservice.checkEmi(scheme, amount, period);		
				
			}
		
	
	
	/*******************************************************************************
	 - Method Name      : addRequest
	 - Input Parameters : LoanRequest request
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Adding Loan request
	  ******************************************************************************/ 
				@PostMapping(value="/apply")
				public String addRequest(@RequestBody LoanRequest request) {
					return custservice.applyForLoan(request);
				}
	
	
	/*******************************************************************************
	 - Method Name      : checkEmi
	 - Input Parameters : Integer id , String pass
	 - Return type      : double
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : Authenticate Customer
	  ******************************************************************************/ 
			@GetMapping("authAdmin/{id}/{pass}")
			public String authCustomerController(@PathVariable("id") Integer id, @PathVariable("pass") String pass){
				logger.info("Customer authentication controller");
				if( custservice.authCustomer(id, pass) != null)
					return "Login Successful";
				else
					return "Login failed";
			}
}



