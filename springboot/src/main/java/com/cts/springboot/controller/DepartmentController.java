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

import com.cts.springboot.cts2020.Department;
import com.cts.springboot.cts2020.Employee;
import com.cts.springboot.cts2020.dao.DepartmentDAO;
import com.cts.springboot.cts2020.dao.EmployeeDAO;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentDAO deptDao;

	@CrossOrigin
	@GetMapping("/deptJson")
	@ResponseBody
	public List<Department> getDeptListJson() {
		System.out.println("Inside getDeptListJson");
		List<Department> listDept = deptDao.getDepartments();
		return listDept;
	}
}
