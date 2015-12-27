package com.vincent.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vincent.springmvc.model.Employee;
import com.vincent.springmvc.service.EmployeeService;

@Controller
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
	
	@RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
	public String listEmployees(ModelMap model){
		model.addAttribute("employeesList", employeeService.listEmployee());
		return "employee";
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(ModelMap model){
		return new ModelAndView("addEmployee", "command", new Employee());
	}
}
