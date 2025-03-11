package com.example.demo.controllers;

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

	@GetMapping("/")
	public String getLogin() {
		return "login";
	}
	
	UserService service;
	
	public UserController(UserService service) {
		this.service = service;
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
	
	@PostMapping("/user/verifyOtp")
	public String verifyOtp(@RequestParam("otp") int otp, @RequestParam("email") String email, Model model) {
		String role = service.verifyOtp(otp, email);
		if (role.equalsIgnoreCase("admin")) {
			return "AdminDashboard";
		} else if (role.equalsIgnoreCase("customer")) {
			return "CustomerDashboard";
		} else {
			model.addAttribute("email", email);
			return "otpFail";
		}
	}
}
