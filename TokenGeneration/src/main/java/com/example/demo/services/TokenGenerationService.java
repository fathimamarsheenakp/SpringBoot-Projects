package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.TokenUser;
import com.example.demo.repositories.TokenGenerationRepository;

@Service
public class TokenGenerationService {

	@Autowired
	TokenGenerationRepository repository;
//	public TokenGenerationService(TokenGenerationRepository repository) {
//		this.repository = repository;
//	}
	
	public boolean getUser(String username, String role) {
		TokenUser user = repository.getByName(username);
		return user != null && user.getRole().equals(role);
	}
	
	public void saveToken(String username, String role, String token) {
		if (getUser(username, role)) {
			TokenUser user = repository.getByName(username);
			user.setToken(token);
			repository.save(user);
		} else {
			return;
		}
	}
}
