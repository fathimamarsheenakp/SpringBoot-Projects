package com.example.demo.services;

import java.util.Random;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	UserRepository repository;
	JavaMailSender mailSender;
	
	public UserService(UserRepository repository, JavaMailSender mailSender) {
		this.repository = repository;
		this.mailSender = mailSender;
	}
	
	public boolean authenticate(String email, String password) {
		User user = repository.findByEmail(email);
		
		if (user != null && user.getPassword().equals(password)) {
			Random random = new Random();
			int otp = random.nextInt(999999);
			user.setOtp(otp);
			repository.save(user);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);
			message.setSubject("Your OTP Code");
			message.setText("Your OTP Code is " + otp);
			mailSender.send(message);
			
			return true;
		} else {
			return false;
		}
	}
	
	public String verifyOtp(int otp, String email) {
		User user = repository.findByEmail(email);
		if (user != null && user.getOtp() == otp) {
			return user.getRole();
		} else {
			return "Invalid otp";
		}
	}
}
