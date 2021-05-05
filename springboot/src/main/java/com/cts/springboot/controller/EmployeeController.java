package com.cts.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.springboot.cts2020.Employee;
import com.cts.springboot.cts2020.dao.EmployeeDAO;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDAO empDao;

	@GetMapping("/elist")
	public ModelAndView getEmpList() {
		List<Employee> listEmp = empDao.getAllEmployees();
		ModelAndView modelAndView = new ModelAndView("EmpView");
		modelAndView.addObject("eList", listEmp);
		return modelAndView;
	}

	@GetMapping("/addcart")
	public ModelAndView addToCart(@RequestParam String name, @RequestParam String sal) {
		System.out.println("Emp name is "+ name);
		ModelAndView modelAndView = new ModelAndView("cart");
		Employee e = new Employee();
		e.setName(name, "From Cart");
		// e.setSalary(Double.valueOf(sal));
	    modelAndView.addObject("emp",e);
	    return modelAndView;
			}
	
	@CrossOrigin
	@GetMapping("/empJson")
	@ResponseBody
	public List<Employee> getEmpListJson() {
		System.out.println("Inside getEmpListJson");
		List<Employee> listEmp = empDao.getEmployeesByCrit();
		return listEmp;
	}
	
}
