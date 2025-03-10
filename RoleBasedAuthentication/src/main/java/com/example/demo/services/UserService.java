package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public String authenticateUser(String name, String password) {
		User user = repository.findByName(name);
		if (user == null) {
			return "invalid user or password";
		} else {
			if (password.equals(user.getPassword())) {
				return user.getRole();
			} else {
				return "invalid user or password";
			}
		}
	}
}
