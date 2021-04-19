package com.cts.springboot.cts2020.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.springboot.cts2020.User;

@SpringBootTest
class AppUserRepoTest {
	
	@Autowired
	AppUserRepo ao;

	@Test
	void testFindByName() {
		User us = ao.findByUserName("user1");
		User us1 = new User("user1","pwd1");
		assertEquals(us1, us);
	}
	
	@Test
	void testCreateUser() {
		User us = new User("user1"+Math.random()+1,"pwd1"+Math.random()+1);
		//assertEquals(us, ao.save(us)); 
	}
	

}
