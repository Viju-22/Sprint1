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


import com.cg.entities.Lad;
import com.cg.services.LadloginService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/ladlogin")
public class LadloginController {

	@Autowired
	LadloginService lservice;
	
	
	@GetMapping("/authLad/{id}/{pass}")
	public String authLads(@PathVariable("id") long id, @PathVariable("pass") String pass){
		
		if( lservice.authLad(id, pass) != null)
			return "Login Successful";
		else
			return "Login failed";
	}
	
	@PostMapping("/createlad")
	public Lad createLad(@Valid @RequestBody Lad l) {
	
		return lservice.createLad(l);
	}
	
	@GetMapping("/listAlllads")
	public List<Lad> listAllLads(){
		
		return lservice.listAllLads();
	}
 

}