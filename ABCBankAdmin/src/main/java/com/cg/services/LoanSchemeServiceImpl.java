package com.cg.services;
/**
-File Name          : LoanSchemeServiceImpl
-Author Name        : Capgemini
-Description        : Implementing class for Lad Services
-Creation Date		: 14/04/2021
*/

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.LoanSchemeDao;
import com.cg.entities.LoanScheme;

@Service("loanschemeservice")
public class LoanSchemeServiceImpl implements LoanSchemeService {
	
	@Autowired
	LoanSchemeDao schemedao;



	/*******************************************************************************
	 - Method Name      : addLoanScheme
	 - Input Parameters : LoanSchem ls
	 - Return type      : LoanScheme
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : adding a Loan Scheme to database
	  ******************************************************************************/
	@Override
	public LoanScheme addLoanScheme(LoanScheme ls) {
		schemedao.saveAndFlush(ls);
		return ls;
	}

	/*******************************************************************************
	 - Method Name      : updateLoanScheme
	 - Input Parameters : LoanSchem ls
	 - Return type      : LoanScheme
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Updating a Loan Scheme in database
	  ******************************************************************************/
	@Override
	public LoanScheme updateLoanScheme(LoanScheme ls) {
		schemedao.saveAndFlush(ls);
		return ls;
	}
    
	
	
	/*******************************************************************************
	 - Method Name      : deleteLoanScheme
	 - Input Parameters : Integer id
	 - Return type      : Boolean
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Deleting a Loan Scheme in database
	  ******************************************************************************/
	@Override
	public Boolean deleteLoanScheme(Integer id) {
		schemedao.deleteById(id);
		return true;
	}

	
	/*******************************************************************************
	 - Method Name      : viewAllScheme
	 - Input Parameters : None
	 - Return type      : List<LoanScheme>
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieving list of Loan Schemes from Database
	  ******************************************************************************/
	@Override
	public List<LoanScheme> viewAllScheme() {
		
		return schemedao.findAll();
	}

	
	/*******************************************************************************
	 - Method Name      : getSchemeById
	 - Input Parameters : None
	 - Return type      : LoanScheme
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Retrieving a Loan Scheme by Id
	  ******************************************************************************/
	@Override
	public LoanScheme getSchemeById(Integer id) {
		Optional<LoanScheme> scheme = schemedao.findById(id);
		return scheme.get();
	}

}

