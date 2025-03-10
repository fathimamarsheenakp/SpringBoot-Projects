package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entries.UnivUser;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public String authentication(String email, String password) {
		UnivUser user = repository.findByEmail(email);
		if (user == null) {
			return "Invalid email or password";
		} else {
			if (user.getPassword().equals(password)){
			return user.getRole();
			} else {
				return "Invalid email or password";
			}
		}
	}
}
