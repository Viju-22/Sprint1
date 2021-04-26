package com.cg.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*Access the urls of your application through login Service
 * You can make separate controllers for different actors
 * specify the actions performed by that actors in your respective controller
 * and design the WebSecurityConfig.java accordingly*/

@RestController
public class LoginController {

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String homePage() {

		logger.info("The user is on Home Page with No authentication");
		return "<h1>Login Successful</h1>";
	}

	@RequestMapping("/admin")
	public String admin() {

		return "<h1>Welcome to Admin Module</h1>";
	}

	@RequestMapping("/customer")
	public String customer() {

		return "<h1>Welcome to Customer Module</h1>";
	}

	@RequestMapping("/lad")
	public String lad() {

		return "<h1>Welcome to Lad Module</h1>";
	}

	


	@RequestMapping("/403")
	public String noAuthority() {
		return "403 Error !!! You Don't Have Permission to access this page";
	}

}
