package com.example.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user/login")
	public String authenticateUser(@RequestBody Map<String, String> request) {
			String name = request.get("name");
			String password = request.get("password");
			String role = userService.authenticateUser(name, password);
			if (role.equalsIgnoreCase("customer")) {
				return "Welcome to customer dashboard";
			} else if (role.equalsIgnoreCase("admin")) {
				return "Welcome to admin dashboard";
			} else {
				return "Invalid user or password";
			}
	}
}
