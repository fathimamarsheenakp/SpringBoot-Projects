package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
public class User {
	
	@RequestMapping("/user/{year}")
	public String getUser(@PathVariable String year, Model model) {
		String message = Integer.parseInt(year) + 10 + "";
		model.addAttribute("message", message);
		return "home";
	}
}
