package com.cg.dao;
/**
-File Name          : CustomerDao
-Author Name        : Capgemini
-Description        : Interface for Customer Repository
-Creation Date		: 12/04/2021
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Customer;

@Repository("customerdao")
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	/*******************************************************************************
	 - Method Name      : authCustomer
	 - Input Parameters : Integer id , String pass
	 - Return type      : Customer
	 - Author           : Capgemini
	 - Creation Date    : 12/04/2021
	 - Description      : Authenticate Customer from Database
	  ******************************************************************************/ 

	@Query("select c from Customer c where (c.custid = ?1 and c.password = ?2)")
	public Customer authCustomer(Integer id, String pass);


}
