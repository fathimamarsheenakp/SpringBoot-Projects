package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ClientService;

@Controller
@RequestMapping("/api")
public class ClientController {
	
	ClientService clientService;
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/display")
	public String displayName(@RequestParam("fn") String firstName, @RequestParam("ln") String lastName, Model model) {
		String fullName = clientService.concatenateName(firstName, lastName);
		model.addAttribute("fullName", fullName);
		return "result";
	}
}
