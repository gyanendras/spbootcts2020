package com.cts.springboot.cts2020.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.springboot.cts2020.Aadhaar;
import com.cts.springboot.cts2020.NoAadharException;
import com.cts.springboot.cts2020.Person;

@SpringBootTest
public class PersonTest {
	@Autowired
	Person p;
	
	/*@BeforeEach
	void runsBeforeTest() {
		p = new Person("Mohit","Keswani");
	}
	
	@AfterEach
	void cleanUp() {
		p=null;
	}*/
	
    @Test
	void testPersonName(){
    	p.setfName("Mohit");
    	p.setlName("Keswani");
	//Person p = new Person("Mohit","Keswani");
	assertEquals("Mohit"+" "+"Keswani",p.getName());
	
	}
    
    @Test
    void testPersonAAdhaar() throws NoAadharException {
    	//Person p = new Person("Mahesh","Arora");
    	Aadhaar a = new Aadhaar();
    	a.setAadhaarNum(23l);
    	assertEquals(23,a.getAadhaarNum().longValue());
    	p.setAadhaar(a);
    	assertEquals(23, p.getAadhaar().getAadhaarNum().longValue());
    	assertTrue(true);
    	
    }
    
    @Test
    void testNoAdhaarException()  {
    	Person p = new Person("Mahesh","Arora");
    	//Aadhaar a = new Aadhaar();
    	//p.setAadhaar(a);
    	Exception exception = 
    			assertThrows(NoAadharException.class, () -> {
    				p.getAadhaar();
        });
    	System.out.println(exception.getMessage());
    	
    }
    
    //Todo Test get Driving License from person

}
