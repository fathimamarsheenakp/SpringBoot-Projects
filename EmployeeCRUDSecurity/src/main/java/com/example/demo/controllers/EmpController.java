package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	EmpService empService;
	
	@PostMapping("/api/onboard")
	public Employee onboard(@RequestBody Employee emp) {
		return empService.onboard(emp);
	}
	
	@GetMapping("/api/getEmployee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empService.getEmployee(id);
	}
	
	@GetMapping("/api/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return empService.getAllEmployee();
	}
	
	@PutMapping("/api/update")
	public Employee update(@RequestBody Employee emp) {
		return empService.update(emp);
	}
	
	@DeleteMapping("api/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return empService.delete(id);
	}
}
