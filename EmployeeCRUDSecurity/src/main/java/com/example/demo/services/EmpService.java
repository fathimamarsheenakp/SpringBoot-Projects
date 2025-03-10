package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepository;
	
	public Employee onboard(Employee emp) {
		return empRepository.save(emp);
	}
	
	public Employee getEmployee(int id) {
		Employee e = empRepository.findById(id).get();
		return e;
	}
	
	public List<Employee> getAllEmployee() {
		List<Employee> empList = empRepository.findAll();
		return empList;
	}
	
	public Employee update(Employee emp) {
		return empRepository.save(emp);
	}
	
	
	public String delete(int id) {
		empRepository.deleteById(id);
		return "Employee deleted successfully.";
	}
}
