package com.cg.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.login.dao.UserDao;
import com.cg.login.entity.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userdao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userdao.getUserByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find the user");
		}

		return new MyUserDetails(user);
	}
	

}
