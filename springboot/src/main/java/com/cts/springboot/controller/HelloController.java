package com.cts.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
	
	@GetMapping("/hi")
	@ResponseBody
	public String helloWorld() {
		return "<h2 style=\"color:Tomato;\">Hello World From Controller!</h2>";
	}
	
	@GetMapping("/tdate")
	public String getDate() {
		return "date";
	}

}
