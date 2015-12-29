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

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployee() {
		Session session = this.sessionFactory.openSession();
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		List<Employee> empList = query.list();
		logger.info("Person List: " + empList);
		session.close();
		return empList;
	}


	@Override
	public void insertEmployee(Employee employee) {
		Session session = this.sessionFactory.openSession();
		logger.info("Employee before: " + employee);
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		logger.info("New Employee is saved successfully with employee details: " + employee);
		session.close();
	}


	@Override
	public void updateEmployee(Employee employee) {
		Session session = this.sessionFactory.openSession();
		logger.info("Employee before: " + employee);
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();
		logger.info("Employee updated sucessfully with employee details: " + employee);
		session.close();
	}


	@Override
	public Employee getEmployeeByI(int id) {
		Session session = this.sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class, new Integer(id));
		logger.info("Employee loaded successfully with employee details: " + employee);
		session.close();
		return employee;
	}


	@Override
	public void removeEmployee(Integer employeeId) {
		System.out.println("hql using Delete");
		Session session = this.sessionFactory.openSession();
		String hql = "DELETE from Employee E WHERE E.id = :employee_id";
		Query query = session.createQuery(hql);
		query.setParameter("employee_id", employeeId);
		int result = query.executeUpdate();
		logger.info("Employee was deleted, row affected: " + result);
		
	}


	@Override
	public void insertOrUpdate(Employee employee) {
		if (employee.getId()==0)
			this.insertEmployee(employee);
		else
			this.updateEmployee(employee);		
	}

}
