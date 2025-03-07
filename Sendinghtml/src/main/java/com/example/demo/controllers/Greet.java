package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Greet {

	@RequestMapping("/greet")
	public String greet() {
		return "home";
	}
}
