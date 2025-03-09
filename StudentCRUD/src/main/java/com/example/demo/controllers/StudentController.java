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

import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/api/onboard")
	public Student onboard(@RequestBody Student stu) {
		return service.onboard(stu);
	}
	
	@GetMapping("/api/getStudent/{id}")
	public Student getStudent(@PathVariable int id) {
		return service.getStudent(id);
	}
	
	@GetMapping("/api/getAllStudents")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}
	
	@PutMapping("/api/update")
	public Student update(@RequestBody Student stu) {
		return service.update(stu);
	}
	
	@DeleteMapping("/api/delete/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
}
