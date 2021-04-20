package com.cg.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.AdminDao;
import com.cg.entities.Admin;

@Service("adminloginservice")
public class AdminServiceImpl implements AdminService{
    
	@Autowired
	AdminDao ldao;
	
	@Override
	public Admin authAdmin(long id, String pass) {
	
		return ldao.authAdmin(id, pass);
	}

	@Override
	public Admin createAdminService(Admin a) {
		
		ldao.saveAndFlush(a);
		
		return a;
	}

	@Override
	public List<Admin> listAllAdmin() {
		return ldao.findAll();
	}
	
	

}
