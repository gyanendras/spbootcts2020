package com.cts.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.cts.springboot.cts2020.Car;

@Configuration
public class ProjConfigurationByJava {
 		
	@SessionScope
	@Bean
	Car getCar() {
		return new Car("1");
	}
	
}
