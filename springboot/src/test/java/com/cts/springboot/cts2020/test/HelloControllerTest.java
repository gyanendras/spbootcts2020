package com.cts.springboot.cts2020.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.springboot.controller.HelloController;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
class HelloControllerTest {
	
	private MockMvc mockMvc;
	 
	
	@BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

	@Test
	void testHelloWorld() throws Exception {
		this.mockMvc.perform(get("/hi"))
		     .andExpect(content()
				.string("<h2 style=\"color:Tomato;\">Hello World From Controller!</h2>")
				)
		      .andExpect(status().is(200));
		
	}
	@Test
	void testGetDate() throws Exception {
		this.mockMvc.perform(get("/tdate"))
		.andExpect(status().is(200))
		.andExpect(view().name("date"));
	}

}
