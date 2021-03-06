package com.cts.springboot.cts2020;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.cts.springboot.cts2020.dao.AppUserRepo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JWTAuthFilter extends BasicAuthenticationFilter {
	
	//@Autowired
	AppUserRepo ar;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader("Authorization");
		UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}

	public JWTAuthFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		Enumeration en = request.getHeaderNames();
		while(en.hasMoreElements()) {
			System.out.println("Header name is "+en.nextElement());
		}
			if (token != null) {
         // parse the token. 
			Jws<Claims> jws;
			try {
				jws = Jwts.parser().setSigningKey("ABC123").parseClaimsJws(token.replace("Bearer ", ""));
				String user = jws.getBody().getSubject();
				ArrayList<SimpleGrantedAuthority> arr = new ArrayList<>();
				// Get the role list from UserRepo
				arr.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				if (user != null) {
					return new UsernamePasswordAuthenticationToken(user, null, arr);
				}
			} catch (JwtException ex) {
				return null;
			}
			return null;
		}
		return null;
	}
	

}
