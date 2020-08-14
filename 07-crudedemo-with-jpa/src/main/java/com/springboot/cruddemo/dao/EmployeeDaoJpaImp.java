package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;
@Repository
public class EmployeeDaoJpaImp implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoJpaImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query query=entityManager.createQuery("from Employee");
		List<Employee> employees=query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee=entityManager.merge(employee);
		employee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int id) {
		Query query=entityManager.createQuery("delete from Employee where id=:id");
		query.setParameter("id",id);
		query.executeUpdate();

	}

}