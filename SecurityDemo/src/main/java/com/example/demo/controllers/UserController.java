package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/user")
	public String user() {
		return "Welcome User to user homepage";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "Welcome Admin to admin homepage";
	}
}
