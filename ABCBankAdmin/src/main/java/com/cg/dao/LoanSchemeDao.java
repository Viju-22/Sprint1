package com.cg.dao;

/**
-File Name          : LoanRequestDao
-Author Name        : Capgemini
-Description        : Interface for Admin
-Creation Date		: 12/04/2021
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.LoanScheme;

@Repository("loanschemedao")
public interface LoanSchemeDao extends JpaRepository<LoanScheme, Integer> {

}
