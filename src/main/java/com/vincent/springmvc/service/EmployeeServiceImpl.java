package com.vincent.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincent.springmvc.dao.EmployeeDao;
import com.vincent.springmvc.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.listEmployee();
	}

}
