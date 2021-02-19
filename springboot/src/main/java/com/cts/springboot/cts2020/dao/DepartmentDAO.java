package com.cts.springboot.cts2020.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cts.springboot.cts2020.Department;
import com.cts.springboot.cts2020.Employee;

@Repository
public class DepartmentDAO {

	
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
	
	public List<Department> getDepartments(){
		
		Connection con = getConnection();
		Statement st = null;
		List<Department> eList = new ArrayList<>();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Departments");
			while(rs.next()) {
					
				Department dept = new Department();
				dept.setDepartmentId(rs.getLong(1));
				dept.setDepartmentName(rs.getString(2));
				eList.add(dept);
				
				
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
	
	public List<Employee> getEmpByDepartment(String depName){
		Connection con = getConnection();
		Statement st = null;
		List<Employee> eList = new ArrayList<>();
		
		String sql = "select * from employees e where e.department_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,depName); // "Cambrault"
				
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
	
	//To do 
	// code getAllDepartments() write its test case also
	// get me all employees who lastname is "King", getEmployeesByLastName()
	// get me all emolyess whose lastname is "Cambrault" but use prepared statement
	// getEmpByLnameParameterized() -- preparedstatement
	// statement, preparedstatement, callableStatement;
	
	
	// transaction - set of statements that 
				// should rollback together or get committed to db together
				/* try {
				con.setAutoCommit(false);
				ps2.executeUpdate();
				ps3.executeUpdate();
				con.commit();
				}catch(Exception e) {
					con.rollback();
				}*/
	

}
