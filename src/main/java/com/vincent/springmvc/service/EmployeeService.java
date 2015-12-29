package com.vincent.springmvc.service;

import java.util.List;

import com.vincent.springmvc.model.Employee;

public interface EmployeeService {
	public List<Employee> listEmployee();

	public void insertEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public Employee getEmployeeById(int id);
	public void deleteEmployee(Integer employeeId);
	public void insertOrUpdate(Employee employee);
}
