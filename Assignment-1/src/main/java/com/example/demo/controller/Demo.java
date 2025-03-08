package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class Demo {

	@RequestMapping("/user/display")
	@ResponseBody
	public String display(@RequestBody Map<String, String> input) {
		String output = "Full Name: " + input.get("firstname") + " " + input.get("lastname") + " " + input.get("age");
		return output;
	}
}
