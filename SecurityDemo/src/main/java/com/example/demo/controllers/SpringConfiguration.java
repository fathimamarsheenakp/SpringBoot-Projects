package com.example.demo.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//		step-1 Disable csrf
		http.csrf(csrf -> {
			csrf.disable();
		});
		
//		step-2 Configuration our rules
		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/user").permitAll();
			auth.requestMatchers("/admin").authenticated();
		});
		
//		step-3 Decide what to display during authentication
		http.httpBasic(httpBasic -> {
			
		});
		
//		step-4 Finalize the rule
		return http.build();
	}
}
