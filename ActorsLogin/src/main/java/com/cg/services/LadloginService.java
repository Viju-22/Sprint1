package com.cg.services;

import java.util.List;

import com.cg.entities.Lad;

public interface LadloginService {
	
	
	public Lad authLad(long id, String pass);
	
	public Lad createLad(Lad l);
	public List<Lad> listAllLads();

}
