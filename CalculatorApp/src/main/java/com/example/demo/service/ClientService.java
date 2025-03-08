package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

	public double add(double num1, double num2) {
		return num1 + num2;
	}
	
	public double sub(double num1, double num2) {
		return num1 - num2;
	}
	
	public double mul(double num1, double num2) {
		return num1 * num2;
	}
	
	public double div(double num1, double num2) {
		if (num2 == 0) {
			throw new ArithmeticException("Division by zero is not allowed");
		} else {
			return num1 / num2;
		}
	}
}
