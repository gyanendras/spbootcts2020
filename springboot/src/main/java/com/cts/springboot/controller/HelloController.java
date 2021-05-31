package com.cts.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.springboot.cts2020.Car;

@Controller
public class HelloController {
	// @Autowired
	//Integer counter;
	
	@Autowired
	Car car;
	
	
	@GetMapping("/hi")
	@ResponseBody
	public String helloWorld() {
		return "<h2 style=\"color:Tomato;\">Hello World From Controller!</h2>";
	}
	
	@GetMapping("/tdate")
	public String getDate(HttpSession session) {
		
		/*Integer count = Integer.valueOf(car.getName());
		++count;
		session.setAttribute("count", 10);
		car.setName(count.toString());
		System.out.println(car.getName());*/
		// set the Authorization header with token.
		//Object objs = restTemplate("/ms1");
		
		return "date";
		
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession session) {
		
		session.invalidate();
		System.out.println("logged out");
		
	}
	
	
}
