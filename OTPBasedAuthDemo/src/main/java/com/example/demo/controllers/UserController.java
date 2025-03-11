package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.UserService;

@Controller
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/user/login")
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		if (service.authenticate(email, password)) {
			model.addAttribute("email", email);
			return "OtpInput";
		} else {
			return "loginFail";
		}
	}
	
	@PostMapping("/user/otp")
	public String verifyOtp(@RequestParam("otp") int otp, @RequestParam("email") String email) {
		String role = service.verifyOtp(otp, email);
		if (role.equalsIgnoreCase("admin")) {
			return "AdminDashboard";
		} else if (role.equalsIgnoreCase("customer")) {
			return "CustomerDashboard";
		} else {
			return "OtpFail";
		}
	}
}
