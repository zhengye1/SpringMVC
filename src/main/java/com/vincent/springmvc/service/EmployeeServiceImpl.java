package com.vincent.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincent.springmvc.dao.EmployeeDao;
import com.vincent.springmvc.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return this.employeeDao.listEmployee();
	}

	@Override
	public void insertEmployee(Employee employee) {
		this.employeeDao.insertEmployee(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.employeeDao.updateEmployee(employee);
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return this.employeeDao.getEmployeeByI(id);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		this.employeeDao.removeEmployee(employeeId);
		
	}

	@Override
	public void insertOrUpdate(Employee employee) {
		this.employeeDao.insertOrUpdate(employee);
		
	}

}
