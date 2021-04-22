package com.cg.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Admin;
import com.cg.services.AdminService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/adminlogin")
public class AdminLogInController {
	
	@Autowired
	AdminService service;
	
	@GetMapping("/authAdmin/{id}/{pass}")
	public String authAdmins(@PathVariable("id") long id, @PathVariable("pass") String pass){
		
		if( service.authAdmin(id, pass) != null)
			return "Login Successful";
		else
			return "Login failed";
	}
	
   
	@PostMapping("/createAdmin")
	public Admin createAdmin(@Valid @RequestBody Admin a) {
	
		return service.createAdminService(a);
	}
	
	@GetMapping("/listAllAdmin")
	public List<Admin> listAllAdmins(){
		
		return service.listAllAdmin();
	}
}
