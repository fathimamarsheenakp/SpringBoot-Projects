package com.example.FirstSpringApp;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
	@Override
	public void build() {
		System.out.println("LAPTOP is being used for building Application");
	}
}
