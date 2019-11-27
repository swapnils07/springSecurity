package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.example.entites.Users;
import com.example.repo.UsersRepository;
import com.example.util.MyUserDetails;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UsersRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Users user=userRepository.findByname(username);
			UserDetails detail= new MyUserDetails(user);
			System.out.println("UserName"+detail.getUsername());
			System.out.println("Password"+detail.getPassword());
			System.out.println("Auth"+detail.getAuthorities());
			return detail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
