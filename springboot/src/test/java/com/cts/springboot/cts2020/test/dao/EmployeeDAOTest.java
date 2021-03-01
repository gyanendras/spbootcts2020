package com.cts.springboot.cts2020.test.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.springboot.cts2020.Employee;
import com.cts.springboot.cts2020.EmployeeMapper;
import com.cts.springboot.cts2020.dao.EmployeeDAO;

import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeDAOTest {
	
	@Autowired
	EmployeeDAO empdao;

	@Test
	void testGetAllEmployees() {
		Resource resource=new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(resource);  
	    EmployeeDAO empdao=(EmployeeDAO)factory.getBean("daoOfEmp");  
	    
	    EmployeeDAO empdao1 = Mockito.mock(EmployeeDAO.class);
	    List<Employee> l1 = new ArrayList();
	    l1.add(new Employee());
 	    Mockito.when(empdao1.getAllEmployees()).thenReturn(l1);
		
		// EmployeeDAO empdao = new EmployeeDAO(); 
		List<Employee> l = empdao1.getAllEmployees();
		Assertions.assertEquals(1, l.size());
	}
	
	// create void testGetAllDepartmentsMock() - just use mock.
	
	@Test
	void testGetConnection() {
		EmployeeDAO empdao = new EmployeeDAO();
		Connection c = empdao.getConnection();
		assertNotNull(c);
		
		
	}
	
	@Test
	void testGetEmpByLname() {
		
		// ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
         //      "applicationContext.xml");
		
		 //  empdao = (EmployeeDAO) context.getBean("daoOfEmp");
		
		// EmployeeDAO empdao = new EmployeeDAO();
		
		List<Employee> eList = empdao.getEmpByLname("Cambrault");
		
		
		System.out.println(eList.get(0).getName());
	}
	
	// write a test case for getAllDepartments
	
	@Test
	void testJDBCTemplate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
		JdbcTemplate jdb = (JdbcTemplate) context.getBean("jdbcTemplate");
	
		String sql  ="select * from employees"; //where first_name = "Steven"
		List<Employee> l = jdb.query(
				   sql, new EmployeeMapper());
		System.out.println(l.get(0).getName());
		Assertions.assertEquals(116, l.size());
		
		// jdb.execute(sql, action)
		
	}
	
	@Test
	void testGetEmployee() {
		Employee e = empdao.getEmployee();
		System.out.println(e.getSalary());
	}
	
	@Test
	void testGetEmployeeByCrit() {
		List<Employee> eList = empdao.getEmployeesByCrit();
		System.out.println(eList.get(0).getName());
	}
	

}
