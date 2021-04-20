package com.cg.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Lad;

@Repository
public interface LadDao extends JpaRepository<Lad, Long>{


	@Query("select l from Lad l where (l.ladid = ?1 and l.password = ?2)")
	public Lad authLad(long id, String pass);

}
