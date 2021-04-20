package com.cg.services;
/**
-File Name          : LoanRequestService

-Author Name        : Capgemini
-Description        : Interface for Admin Service
-Creation Date		: 12/04/2021
*/
import java.util.List;

import com.cg.entities.LoanScheme;


public interface LoanSchemeService {
	
	public LoanScheme addLoanScheme(LoanScheme ls);
	public LoanScheme updateLoanScheme(LoanScheme ls);
	public Boolean deleteLoanScheme(Integer id);
	public List<LoanScheme> viewAllScheme();
	
	public LoanScheme getSchemeById(Integer id);

}
