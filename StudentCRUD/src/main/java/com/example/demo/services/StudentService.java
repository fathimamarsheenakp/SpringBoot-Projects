package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
	public Student onboard(Student stu) {
		return repo.save(stu);
	}
	
	public Student getStudent(int id) {
		return repo.findById(id).get();
	}
	
	public List<Student> getAllStudents() {
		return repo.findAll();
	}
	
	public Student update(Student stu) {
		return repo.save(stu);
	}
	
	public String delete(int id) {
		repo.deleteById(id);
		return "Student with id-" + id + " deleted successfully!"; 
	}
}
