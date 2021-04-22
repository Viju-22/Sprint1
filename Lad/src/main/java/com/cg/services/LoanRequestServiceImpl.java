package com.cg.services;

/**
-File Name          : LoanRequestServiceImpl
-Author Name        : Capgemini
-Description        : Implementing class for Lad Services
-Creation Date		: 14/04/2021
*/

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.LoanRequestDao;
import com.cg.entities.LoanRequest;

@Service("loanrequestservice")
public class LoanRequestServiceImpl implements LoanRequestService{
	
	@Autowired
	LoanRequestDao requestdao;
    
	
	/*******************************************************************************
	 - Method Name      : addloanRequest
	 - Input Parameters : LoanRequest request
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Inserting a LoanRequest into  the database.
	  ******************************************************************************/ 
	@Override
	public String addloanRequest(LoanRequest request) {
		requestdao.saveAndFlush(request);
		return "Applied Successfully";
	}
	
	
	
	/*******************************************************************************
	 - Method Name      : verifyLoanRequest
	 - Input Parameters : LoanRequest request
	 - Return type      : String
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Verifying the Customer's Loan Request
	  ******************************************************************************/
	@Override
	public String verifyLoanRequest(LoanRequest request) {
		
		LoanRequest result = request;
		if(request.getAge() >=20 && request.getAge()<=40 && request.getIncome()>50000) {
			result.setStatus("Approved");
		}else {
			result.setStatus("Rejected");
		}
		requestdao.saveAndFlush(result);
		return result.getStatus();
	}

	

	/*******************************************************************************
	 - Method Name      : viewAllLoanRequests
	 - Input Parameters : None
	 - Return type      : List<LoanRequest>
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieving list of loan requests
	  ******************************************************************************/
	@Override
	public List<LoanRequest> viewAllLoanRequests() {
		return requestdao.findAll();
	}

	
	
	/*******************************************************************************
	 - Method Name      : getRequestById
	 - Input Parameters : Integer id
	 - Return type      : LoanRequest
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieving LoanRequest by Id
	  ******************************************************************************/
	@Override
	public LoanRequest getRequestById(Integer id) {
		Optional<LoanRequest> loanrequest = requestdao.findById(id);
		return loanrequest.get();
	}

}
