package com.vincent.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vincent.springmvc.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployee() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		List<Employee> empList = query.list();
		logger.info("Person List: " + empList);
		return empList;
	}

}
