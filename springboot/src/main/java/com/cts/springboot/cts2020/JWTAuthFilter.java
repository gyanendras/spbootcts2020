package com.cts.springboot.cts2020;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthFilter extends BasicAuthenticationFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader("Authorization");
		super.doFilterInternal(request, response, chain);
	}

	public JWTAuthFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	

}
