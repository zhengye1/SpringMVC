package com.vincent.springmvc.dao;

import java.util.List;

import com.vincent.springmvc.model.Employee;

public interface EmployeeDao {
	public void insertEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public Employee getEmployeeByI(int id);
	public List<Employee> listEmployee();
	public void removeEmployee(Integer employeeId);
	public void insertOrUpdate(Employee employee);
}
