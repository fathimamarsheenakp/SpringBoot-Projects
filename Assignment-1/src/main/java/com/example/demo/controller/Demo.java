package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class Demo {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/user/display")
	@ResponseBody
	public String display(@RequestBody Map<String, String> input) {
		String output = "Full Name: " + input.get("firstname") + " " + input.get("lastname") + " " + input.get("age");
		return output;
	}
	
	@RequestMapping("/user/percentage")
	public String getPercentage(@RequestParam("tm") int total, @RequestParam("nos") int numberOfSubjects, Model model) {
		float percentage = ((float)total / (numberOfSubjects * 100)) * 100;
		model.addAttribute("percent", percentage);
		return "index";
	}
}
