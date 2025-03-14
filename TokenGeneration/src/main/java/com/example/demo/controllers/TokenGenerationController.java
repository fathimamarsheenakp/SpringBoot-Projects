package com.example.demo.controllers;

import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class TokenGenerationController {

	private final SecretKey SIGNING_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	@Autowired
	TokenGenerationService service;
	
	@GetMapping("/generate")
	public String addTokenToClient(@RequestParam("username") String username, @RequestParam("role") String role, HttpServletResponse response) {
		String token = generateToken(username, role);
		
		Cookie cookie = new Cookie("authToken", token);
		cookie.setMaxAge(3600);
		cookie.setHttpOnly(true);
		cookie.setSecure(false); // Set to true if Https
		cookie.setPath("/");
		
		response.addCookie(cookie);
		response.addHeader("Set-Cookie", String.format("authToken = %s; HttpOnly; SameSite:None", token));
		response.setStatus(HttpServletResponse.SC_OK);
		
		return "success";
	}
	
	
	public String generateToken(String username, String role) {
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
	public String tokenValidation(HttpServletRequest request) {
	    Cookie[] cookies = request.getCookies();
	    if (cookies == null) {
	        return "No cookies found";
	    }

	    String token = null;
	    for (Cookie cookie : cookies) {
	        if ("authToken".equals(cookie.getName())) {
	            token = cookie.getValue();
	            break;
	        }
	    }

	    if (token == null || token.isEmpty()) {
	        return "Token is missing or empty";
	    }

	    try {
	        JwtParser parser = Jwts.parserBuilder().setSigningKey(SIGNING_KEY).build();
	        Jws<Claims> jws = parser.parseClaimsJws(token);
	        Claims claims = jws.getBody();
	        String name = claims.getSubject();
	        String role = (String) claims.get("role");
	        return "User: " + name + " Role: " + role;
	    } catch (Exception e) {
	        return "Invalid token: " + e.getMessage();
	    }
	}

}


