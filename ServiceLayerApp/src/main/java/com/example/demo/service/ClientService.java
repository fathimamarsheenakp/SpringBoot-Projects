package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
	public String concatenateName(String firstName, String lastName) {
		return firstName + " " + lastName;
	}
}
