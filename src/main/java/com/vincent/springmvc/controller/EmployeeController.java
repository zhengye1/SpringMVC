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

import com.vincent.springmvc.model.Employee;
import com.vincent.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//Logger file
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
	public String listEmployees(ModelMap model){
		model.addAttribute("employeesList", this.employeeService.listEmployee());
		return "employee";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee(ModelMap model){
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@RequestMapping(value = "/edit/{empId}", method=RequestMethod.GET)
	public String editEmployee(@PathVariable("empId") int id, ModelMap model){
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		logger.info("Employee controllre:48 " + model);
		return "addEmployee";
	}
	
	@RequestMapping(value = {"/updateEmployee", "/edit/updateEmployee"}, method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee,  ModelMap model){
		if(employee.getId() == null)
			this.employeeService.insertEmployee(employee);
		else
			this.employeeService.updateEmployee(employee);
		model.addAttribute("employeesList", this.employeeService.listEmployee());
		return "redirect:/employee/listEmployees";
	}
	
	@RequestMapping(value = "/delete/{empId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("empId") Integer empId, ModelMap model){
		this.employeeService.deleteEmployee(empId);
		model.addAttribute("employeesList", this.employeeService.listEmployee());
		return "redirect:/employee/listEmployees";
	}

}
