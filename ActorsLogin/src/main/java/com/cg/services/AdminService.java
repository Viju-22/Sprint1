package com.cg.services;

import java.util.List;

import com.cg.entities.Admin;

public interface AdminService {
	
	public Admin authAdmin(long id, String pass);
	public Admin createAdminService(Admin a);
	public List<Admin> listAllAdmin();
	

}
