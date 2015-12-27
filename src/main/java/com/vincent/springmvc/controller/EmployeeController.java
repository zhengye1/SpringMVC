package com.vincent.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vincent.springmvc.model.Employee;
import com.vincent.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//Logger file
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
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
		model.addAttribute("employeesList", this.employeeService.listEmployee());
		return "employee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(ModelMap model){
		return new ModelAndView("addEmployee", "command", new Employee());
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employeeForm") Employee employee, ModelMap model){
		logger.error("Employee id: " + employee.getId());
		this.employeeService.insertEmployee(employee);
		model.addAttribute("employeesList", this.employeeService.listEmployee());
		return "employee";
	}
	
	@RequestMapping(value = "/delete/{empId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("empId") Integer empId, ModelMap model){
		this.employeeService.deleteEmployee(empId);
		model.addAttribute("employeesList", this.employeeService.listEmployee());
		return "employee";
	}
	@RequestMapping(value = "/edit/{empId}", method=RequestMethod.GET)
	public String editEmployee(@PathVariable("empId") int id, ModelMap model){
		model.addAttribute("addEmployee", this.employeeService.getEmployeeById(id));
		//model.addAttribute("employeesList", this.employeeService.listEmployee());
		return "addEmployee";
	}
}
