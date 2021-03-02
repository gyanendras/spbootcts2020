package com.cts.springboot.cts2020.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.springboot.cts2020.RectangleLombok;

@SpringBootTest
class RectangleLombokTest {
	@Autowired
	RectangleLombok rct;

	@Test
	void testObjectInjected() {
		assertNotNull(rct);
	}
	
	@Test
	void testCalculateArea() {
		rct.setLenght(2.0);
		rct.setWidth(3.0);
		System.out.println(rct);
		assertEquals(6, rct.calculateArea());
	}
	

}
