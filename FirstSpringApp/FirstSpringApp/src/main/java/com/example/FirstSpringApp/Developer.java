package com.example.FirstSpringApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Developer {

	Computer computer;
	
//	CONSTRUCTOR DEPENDENCY INJECTION
	public Developer(Computer computer) {
		this.computer = computer;
	}
	
//	SETTER DEPENDENCY INJECTION
//	@Autowired
//	public void setDeveloper(Computer computer) {
//		this.computer = computer;
//	}
	
//	@Autowired
//	Computer computer;
	
	public void develop() {
		computer.build();
	}
}
