package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	EmpRepository empRepository;
	
	public Employee giveEmployee(int id) {
		Employee e = empRepository.findById(id).get();
		return e;
	}
} 
