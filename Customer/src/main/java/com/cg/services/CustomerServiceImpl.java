package com.cg.services;
/**
-File Name          : CustomerServiceImpl

-Author Name        : Capgemini
-Description        : CustomerService Implementation Class
-Creation Date		: 14/04/2021
*/

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.dao.CustomerDao;
import com.cg.entities.Customer;
import com.cg.entities.LoanRequest;

@Service("customerservice")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao cdao;
	
	@Autowired
	RestTemplate rest;

	/*******************************************************************************
	 - Method Name      : addCustomer
	 - Input Parameters : Customer c
	 - Return type      : Customer
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Inserting a Customer into  the database.
	  ******************************************************************************/ 
	
	@Override
	public Customer addCustomer(Customer c) {
		cdao.saveAndFlush(c);
		return c;
	}
	
	
	
	/*******************************************************************************
	 - Method Name      : getCustomerById
	 - Input Parameters : Integer id
	 - Return type      : Appointment
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieve a Customer from the database.
	  ******************************************************************************/ 

	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> customer = cdao.findById(id);
		return customer.get();
	}

	

	/*******************************************************************************
	 - Method Name      : viewAllCustomers
	 - Input Parameters : None
	 - Return type      : List<Customer>
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieve a list of Customers from the database.
	  ******************************************************************************/ 

	@Override
	public List<Customer> viewAllCustomers() {
		
		return cdao.findAll();
	}
	
	
	
	/*******************************************************************************
	 - Method Name      : checkEmi
	 - Input Parameters : String scheme, double amount, double period
	 - Return type      : double
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Calculate EMI value
	  ******************************************************************************/ 
	

	@Override
	public double checkEmi(String scheme, double amount, double period) {
		double emi=0;
		double rate=0;
		double am = amount;
		double time= period;
		
		switch(scheme) {
		
		case "Home Loan":
			
			rate=(am*12)/100;
			emi = (am + rate)/time;
		    break;
		
		case "Car Loan":
			
			rate=(am*15)/100;
			emi = (am + rate)/time;
		    break;
		
		case "Medical Loan":
			rate=(am* 14)/100;
			emi = (am + rate)/time;
		    break;
		    
		case "Gold Loan":
			rate=(am*16)/100;
			emi = (am + rate)/time;
		    break;
		 
		default:
			emi=0;
		}
		
		return emi;
	
	}
	
	
	
	/*******************************************************************************
	 - Method Name      : applyForLoan
	 - Input Parameters : LoanRequest request
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Apply for a loan Scheme
	  ******************************************************************************/ 
	 
	String url = "http://localhost/lads/lad/createrequest";
	@Override
	public String applyForLoan(LoanRequest request) {
		rest.postForObject(url, request, String.class);
		
		return "Request added";
	}
	
	
	
	/*******************************************************************************
	 - Method Name      : authCustomer
	 - Input Parameters : Integer id , String pass
	 - Return type      : Customer
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Authenticate a Customer from the database.
	  ******************************************************************************/ 

	
	@Override
	public Customer authCustomer(Integer id, String pass) {
	
		return cdao.authCustomer(id, pass);
	}


}
