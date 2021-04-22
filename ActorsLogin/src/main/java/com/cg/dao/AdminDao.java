package com.cg.dao;


	
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Admin;

	@Repository
	public interface AdminDao extends JpaRepository<Admin, Long>{

	
		@Query("select a from Admin a where (a.adminid = ?1 and a.password = ?2)")
		public Admin authAdmin(long id, String pass);

	}


