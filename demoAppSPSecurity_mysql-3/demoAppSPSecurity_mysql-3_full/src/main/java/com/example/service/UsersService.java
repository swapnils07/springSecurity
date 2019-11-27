package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entites.Users;
import com.example.repo.UsersRepository;

@Service
public class UsersService {

	
	  @Autowired 
	  UsersRepository userRepository;
	
	
	public List<Users> getAllUsers(){
		return userRepository.findAll();
		//return new ArrayList<Users>();
	}


	public Users createNewUser(Users users) {
		Users savedUser=userRepository.save(users);
		return savedUser;
	}


	public Users getUser(String username) {
		try {
			Users u=userRepository.findByname(username);
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
