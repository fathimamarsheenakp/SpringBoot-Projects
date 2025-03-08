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
	
	@RequestMapping("/calculator")
	public String calculate(@RequestParam("num1") double n1,
			@RequestParam("num2") double n2,
			@RequestParam("op") String operation, 
			Model model) {
		double res;
		switch (operation) {
		case "add": {
			res = clientService.add(n1, n2);
			break;
		}
		
		case "sub": {
			res = clientService.sub(n1, n2);
			break;
		}
		
		case "mul": {
			res = clientService.mul(n1, n2);
			break;
		}
		
		case "div": {
			if (n2 != 0) {
				res = clientService.div(n1, n2);
				break;
			} else {
				model.addAttribute("error", "Division by zero is not allowed");
				return "result";
			}
		}
		default:
			model.addAttribute("error", "InvalidOperation");
			return "result";
		}
		model.addAttribute("num1", n1);
		model.addAttribute("num2", n2);
		model.addAttribute("op", operation);
		model.addAttribute("res", res);
		return "result";
	}
}
