package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.LadDao;
import com.cg.entities.Lad;

@Service("ladloginservice")
public class LadloginServiceImpl implements LadloginService {
    
	@Autowired
	LadDao dao;
	
	
	@Override
	public Lad authLad(long id, String pass) {
		
	return dao.authLad(id, pass);
	}

	@Override
	public Lad createLad(Lad l) {
		dao.saveAndFlush(l);
		return l;
	}

	@Override
	public List<Lad> listAllLads() {
		
		return dao.findAll();
	}

}
