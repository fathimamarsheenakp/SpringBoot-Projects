package com.example.FirstSpringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringAppApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(FirstSpringAppApplication.class, args);
		Developer developer = ac.getBean(Developer.class);
		developer.develop();
		}
}
