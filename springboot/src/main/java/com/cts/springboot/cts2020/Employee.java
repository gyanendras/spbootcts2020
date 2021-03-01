package com.cts.springboot.cts2020;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
   //attributes/memeber variables/properties
	@Id
	private Long employeeId;
	Double salary;
	

	LocalDate hireDate;
	String firstName;
	String lastName;
	// Address addr;
	private static Integer retirementAge = 60;
	
	
    //constructors
	public Employee(String firstName, Long id) {
		firstName = firstName;
		employeeId = id;
	}
	
	//constructors
	public Employee(String firstName,String lastName, Long id) {
		this.firstName = firstName;
		this.lastName = lastName;
		employeeId = id;
	}
	//constructors - default
	public Employee() {
		employeeId = 0l;
	}


	public static void main(String[] args) {
		Employee ram = new Employee("Ram","Sri",11l);
		Employee tom = new Employee("Tom",2l);
		
		System.out.println(ram.getName());
		System.out.println(tom.getName());
		tom.setName("TomNew", "Smith");
		System.out.println(tom.getName());
		tom.setSalary(1200.00);
		System.out.println(tom.calculateBonus());
		System.out.println(tom.getRetirementAge());
		System.out.println(ram.getRetirementAge());
		ram.setRetirementAge(70);
		System.out.println(tom.getRetirementAge());
		System.out.println(ram.getRetirementAge());
		char c = 'a';
		Character c1 = c;
		c1='b';
		c1 = new Character('o');
		c1 = Character.valueOf('o'); 
		c = c1;
		
		String s = tom.getName();
		
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public static void setRetirementAge(Integer retirementAge) {
		Employee.retirementAge = retirementAge;
	}

	public void setRetirementAge(int age) {
		retirementAge = age;
		
	}

	public Integer getRetirementAge() {
		return retirementAge;
	}

	public void setSalary(double sal) {
		salary = sal;
		
	}
	
	public Double getSalary() {
		return salary;
	}

	public String getName() {
		return firstName +" "+ lastName;
		
		
	}
	
	public void setName(String firstName, String lastName) {
		firstName = firstName;
		lastName = lastName;
	}
	
	public double calculateBonus() {
		return 5*salary/100+retirementAge/10;
	}
  
	
}
