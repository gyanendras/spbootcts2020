package com.cts.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.cts.springboot.cts2020.JWTAuthFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig  extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 	 //super.configure(auth);
 	 auth.inMemoryAuthentication()
 	     .withUser("user")
	     .password(passwordEncoder().encode("userpwd"))
	     .roles("USER")
	     .and()
	     .withUser("admin")
	     .password(passwordEncoder().encode("adminpwd"))
	     .roles("ADMIN");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/hi")
		.hasRole("USER")
		.antMatchers("/empJson")
		.hasRole("ADMIN")
		.antMatchers("/hi")
		.hasAnyRole("USER","ADMIN")
		.antMatchers("/logout")
		.hasAnyRole("USER","ADMIN");
		http.formLogin();
		http.addFilter(new JWTAuthFilter(authenticationManager()));
	}

	
	
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
