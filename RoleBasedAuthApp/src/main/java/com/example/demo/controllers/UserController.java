package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserService;

@Controller
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/user/login")
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password) {
		String rol = userService.authentication(email, password);
		if (rol.equalsIgnoreCase("student")) {
			return "studentPortal";
		} else if (rol.equalsIgnoreCase("teacher")) {
			return "teacherPortal";
		} else {
			return "loginFail";
		}
	}
}
