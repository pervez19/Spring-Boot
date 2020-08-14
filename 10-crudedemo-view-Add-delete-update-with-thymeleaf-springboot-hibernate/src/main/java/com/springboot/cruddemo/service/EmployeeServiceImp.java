package com.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.cruddemo.dao.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
		
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> employee= employeeRepository.findById(id) ;
		Employee theEmployee=null;
		if(employee.isPresent())
		{
			theEmployee=employee.get();
		}
		else
		{
			throw new RuntimeException("Employee not found by this ID: "+id);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

}
