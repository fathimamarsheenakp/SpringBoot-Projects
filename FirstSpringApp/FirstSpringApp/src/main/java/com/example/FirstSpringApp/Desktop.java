package com.example.FirstSpringApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer {
	 @Override
	public void build() {
		 System.out.println("DESKTOP is being used for building Application");
	}
}
