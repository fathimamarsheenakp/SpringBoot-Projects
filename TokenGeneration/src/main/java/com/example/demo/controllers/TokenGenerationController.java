package com.example.demo.controllers;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.TokenGenerationService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("/api")
public class TokenGenerationController {

	private final SecretKey SIGNING_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	@Autowired
	TokenGenerationService service;
	
	@PostMapping("/generate")
	public String generateToken(@RequestParam("username") String username, @RequestParam("role") String role) {
		if (service.getUser(username, role)) {
			JwtBuilder builder = Jwts.builder();
			builder.setSubject(username);
			builder.claim("role", role);
			builder.setIssuedAt(new Date(System.currentTimeMillis()));
			builder.setExpiration(new Date(System.currentTimeMillis() + 3600000));
			builder.signWith(SIGNING_KEY);
			String token = builder.compact();
			service.saveToken(username, role, token);

			return token;
		} 
		return "No User";
	}
	
	@PostMapping("/validate")
	public String tokenValidation(@RequestBody Map<String, String> request) {
		String username = request.get("username");
		String role = request.get("role");
		String token = request.get("authToken");
		
		if (!service.getUser(username, role)) {
            return "Invalid User";
        }
		
		if (token == null || token.isEmpty()) {
            return "Invalid request: Token is required";
        }
		
		try {
            Jws<Claims> parsedToken = Jwts.parserBuilder()
                .setSigningKey(SIGNING_KEY)
                .build()
                .parseClaimsJws(token);

            return "Token is valid. User: " + parsedToken.getBody().getSubject();
        } catch (Exception e) {
            return "Invalid or expired token";
        }
	}
}


