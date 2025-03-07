package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.websocket.server.PathParam;

@Controller
public class Greet {
	
	@RequestMapping("/greet")
	@ResponseBody
	public String greetUser(@RequestParam("name") String username) {
		return "HELLO " + username;
	}
	
	@RequestMapping("/data/{name}")
	@ResponseBody
	public String getData(@PathVariable String name) {
		return "Hello " + name;
	}
	
	@RequestMapping("/display")
	@ResponseBody
	public String displayData(@RequestBody Map<String, String> input) {
		return "Hello " + input.get("username");
	}
}
