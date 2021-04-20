package com.cg.loanrequestservicetest;

import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dao.LoanRequestDao;
import com.cg.entities.LoanRequest;
import com.cg.services.LoanRequestServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class Loanrequestservicetest {
	

	@InjectMocks
	LoanRequestServiceImpl requestservice;
	
	@Mock
	LoanRequestDao ldao;
	
	/*******************************************************************************
	 - Method Name      : addLoanRequestTest
	 - Input Parameters : None 
	 - Return type      : void
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Testing addLoanRequestTest Method
	  ******************************************************************************/ 
	
	@Test
	public void addLoanRequestTest() {

    Date date = new Date();
    LoanRequest req = new LoanRequest(1,"Home Loan",2,"Vijay",23,60000,"Aurangabad","844415706785",date,"Pending" );
    
    when(ldao.saveAndFlush(req)).thenReturn(req);
   
    assertEquals("Applied Successfully", requestservice.addloanRequest(req));
    
}

	

	/*******************************************************************************
	 - Method Name      : getLoanRequestByIdTest
	 - Input Parameters : None 
	 - Return type      : void
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Testing getLoanRequestByIdTest Method
	  ******************************************************************************/ 
	
    @Test
	public void getLoanRequestByIdTest() {
    	
     Date date = new Date();
     LoanRequest req = new LoanRequest(1,"Home Loan",2,"Vijay",23,60000,"Aurangabad","844415706785",date,"Pending" );
     Date date2 = new Date();
     LoanRequest req2 = new LoanRequest(2,"Car Loan",3,"Rahul",23,50000,"Panvel","844415706785",date2,"Pending" );
	 ldao.saveAndFlush(req);
	 ldao.saveAndFlush(req2);
     when(ldao.findById(req.getCustid())).thenReturn(Optional.of(req));
     assertEquals(req, requestservice.getRequestById(req.getCustid()));
    }
    
    
    /*******************************************************************************
	 - Method Name      : viewAllLoanRequestsTest
	 - Input Parameters : None 
	 - Return type      : void
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Testing viewAllLoanRequestsTest Method
	  ******************************************************************************/ 
    @Test
    public void viewAllLoanRequestsTest() {
    	
 	  List<LoanRequest> list = new ArrayList<>();
 	   
 	  Date date1 = new Date();
      LoanRequest req1 = new LoanRequest(1,"Home Loan",2,"Vijay",23,60000,"Aurangabad","844415706785",date1,"Pending" );
      
      Date date2 = new Date();
      LoanRequest req2 = new LoanRequest(2,"Car Loan",3,"Rahul",23,50000,"Panvel","844415706785",date2,"Pending" );
      list.add(req1);
      list.add(req2);
      
      when(ldao.findAll()).thenReturn(list);
      List<LoanRequest> requestList = requestservice.viewAllLoanRequests();
      assertEquals(2, requestList.size());
      verify(ldao, times(1)).findAll();

    }
    
    
    
    /*******************************************************************************
	 - Method Name      : verifyLoanRequestTest
	 - Input Parameters : None 
	 - Return type      : void
	 - Author           : Capgemini
	 - Creation Date    : 14/04/2021
	 - Description      : Testing verifyLoanRequestTest Method
	  ******************************************************************************/ 
    
    @Test
    public void verifyLoanRequestTest() {
    	Date date = new Date();
        LoanRequest req  = new LoanRequest(1,"Home Loan",2,"Vijay",23,60000,"Aurangabad","844415706785",date,"Pending" );
       
        assertEquals("Approved", requestservice.verifyLoanRequest(req));
    	
    }
	
	
	
	
}