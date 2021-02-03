package com.cts.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		    modelAndView.addObject("eList",listEmp);
		return modelAndView;
	}
}
