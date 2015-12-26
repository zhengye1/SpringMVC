package com.vincent.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vincent.springmvc.service.EmployeeService;

@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String welcomeEmployee(ModelMap model){
		model.addAttribute("name", "Hello World!");
		model.addAttribute("greetings", "Welcome to Spring MVC");
		return "hello";
	}
	
	@RequestMapping(value = "/listemployee", method = RequestMethod.GET)
	public String listEmployees(ModelMap model){
		model.addAttribute("employeesList", employeeService.listEmployee());
		return "employee";
	}
}
