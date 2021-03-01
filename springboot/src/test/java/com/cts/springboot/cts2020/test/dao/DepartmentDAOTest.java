package com.cts.springboot.cts2020.test.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.springboot.cts2020.Department;
import com.cts.springboot.cts2020.dao.DepartmentDAO;

@SpringBootTest
class DepartmentDAOTest {
	@Autowired
	DepartmentDAO ddao;
	@Test
	void testGetDepartments() {
		List<Department> dl = ddao.getDepartments();
		assertTrue(dl.size()>1);
	}

}
