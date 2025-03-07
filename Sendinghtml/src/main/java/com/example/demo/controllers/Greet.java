package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Greet {

	@RequestMapping("/greet")
	public String greet(@RequestParam String username, Model model) {
		String messageValue = "Hello " + username;
		model.addAttribute("message", messageValue);
		return "home";
	}
}
