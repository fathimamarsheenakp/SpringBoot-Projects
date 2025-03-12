package com.example.demo.filters;

import java.io.IOException;

import org.springframework.stereotype.Controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/api/*")
@Controller
public class OurFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String url = req.getRequestURI();
		if (url.equals("/api/greet")) {
			chain.doFilter(request, response);
		} else {
			String name = req.getParameter("username");
			if (name.length() != 0) {
				req.setAttribute("UserType", "Customer");
				chain.doFilter(request, response);
			} else {
				res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
	}

}
