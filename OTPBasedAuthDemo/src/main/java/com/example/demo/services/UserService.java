package com.example.demo.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public boolean authenticate(String email, String password) {
		User user = repository.findByEmail(email);
		
		if (user != null && user.getPassword().equals(password)) {
			int otp = generateOtp();
	        user.setOtp(otp);
	        repository.save(user);
	        return true;
		} else {
			return false;
		}
	}
	
	public int generateOtp() {
	    Random random = new Random();
	    return 100000 + random.nextInt(900000); // Generates a 6-digit OTP
	}
	
	public String verifyOtp(int otp, String email) {
		User user = repository.findByEmail(email);
		if (user == null) {
			return "OTP verification failed";
		} else {
			if (user.getOtp() == otp) {
				return user.getRole();
			} else {
				return "OTP verification failed";
			}
		}
	}
}
