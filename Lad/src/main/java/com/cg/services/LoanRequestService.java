package com.cg.services;
/**
-File Name          : LoanRequestService
-Author Name        : Capgemini
-Description        : Interface for LAD Service
-Creation Date		: 12/04/2021
*/

import java.util.List;


import com.cg.entities.LoanRequest;

public interface LoanRequestService{
	
	public String addloanRequest(LoanRequest request);
	
	public String verifyLoanRequest(LoanRequest request);
	
	
	public List<LoanRequest> viewAllLoanRequests();
	
	public LoanRequest getRequestById(Integer id);

}
