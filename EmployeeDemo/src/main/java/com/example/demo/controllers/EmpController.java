package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/api/getuser/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		return empService.giveEmployee(id);
	}
}
