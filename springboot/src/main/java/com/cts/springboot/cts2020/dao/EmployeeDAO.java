package com.cts.springboot.cts2020.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cts.springboot.cts2020.Employee;
import com.cts.springboot.cts2020.Department;

@Repository
public class EmployeeDAO {
	private static Logger logger = LoggerFactory.getLogger(EmployeeDAO.class);

	
	 @PersistenceContext
	    private EntityManager em;
	 
	
	public Connection getConnection(){
		Connection con = null;
		try {
			con = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/hr", "root", "full2work");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		 return con;
	}
	
	public List<Employee> getAllEmployees(){
		
		Connection con = getConnection();
		Statement st = null;
		List<Employee> eList = new ArrayList<>();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employees");
			while(rs.next()) {
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getString(2));
				//System.out.println(rs.getString(3));
				//System.out.println(rs.getDate("hire_date"));
				
				Employee emp = new Employee();
				emp.setName(rs.getString(2), rs.getString(3));
				emp.setSalary(rs.getDouble("salary"));
				eList.add(emp);
				
				
			}
						
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return eList;
		
	}
	
	public List<Employee> getEmpByLname(String lname){
		Connection con = getConnection();
		Statement st = null;
		List<Employee> eList = new ArrayList<>();
		
		String sql = "select * from employees e where e.last_name = ?"
				+ "and department_id = ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,lname); // "Cambrault"
			ps.setInt(2, 80);
			
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				Employee e = new Employee();
				e.setName(rs.getString(2), rs.getString(3));
				eList.add(e);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return eList;
	}
	
	
	public Employee getEmployee(){
		Employee e = null;
		try {
		logger.info("Start getEmployee");
		e = em.find(Employee.class, 102l);
		logger.debug("Employee Found {} and its salary is  {} " ,e.getName(),e.getSalary());
		
		}catch(Exception err) {
			
			logger.error(err.getMessage());
		}
		return e;
	}
	
	public List<Employee> getEmployeesByCrit() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> empRt = cq.from(Employee.class);
		cq.select(empRt);
		TypedQuery<Employee> q = em.createQuery(cq);
		List<Employee> allEmployee = q.getResultList();
		
		return allEmployee;
	}
	
	public List<Employee> getEmployeesWithWhereByCrit() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> empRt = cq.from(Employee.class);
		
		Metamodel m = em.getMetamodel();
		EntityType<Employee> emp_ = m.entity(Employee.class);
		Expression ex = empRt.get(emp_.getSingularAttribute("salary"));
		Predicate eid = cb.equal(ex, "17000");
		cq.where(eid);
		 
		cq.select(empRt);
		TypedQuery<Employee> q = em.createQuery(cq);
		List<Employee> selectEmployee = q.getResultList();
		
		return selectEmployee;
	
	}


}
