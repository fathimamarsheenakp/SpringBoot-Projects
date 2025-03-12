package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class FirstController {

	@GetMapping("/user")
	public String getUser(@RequestParam String username, HttpServletRequest req) {
		String res = (String) req.getAttribute("UserType");
		return "Hello " + username + "Welcome to " + res + " dashboard";
	}
}
