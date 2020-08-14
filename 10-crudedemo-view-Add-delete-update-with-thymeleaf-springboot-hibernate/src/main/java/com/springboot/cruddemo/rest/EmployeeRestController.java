package com.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeServiceImp;

@Controller
@RequestMapping("/employees")
public class EmployeeRestController {

	private EmployeeServiceImp employeeService;

	@Autowired
	public EmployeeRestController(EmployeeServiceImp employeeServiceImp) {
		this.employeeService = employeeServiceImp;
	}
	
	@GetMapping("/list")
	public String findAll(Model model)
	{
		 List<Employee> employees= employeeService.findAll();
		 model.addAttribute("employees",employees);
		 
		return "listEmployee";
	}
	
	@GetMapping("/showFromForAdd")
	public String showFromForAdd(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		 
		return "employeeForm";
	}

	@GetMapping("/showFromForUpdate")
	public String showFromForUpdate(@RequestParam("employeeId") int id,Model model)
	{
		
		Employee employee=employeeService.findById(id);
		model.addAttribute("employee",employee);
		return "employeeForm";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id,Model model)
	{
		
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
	

	@PostMapping("/save")
	public String addEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.save(employee);
		return "redirect:/employees/list";
		
	}

	
}
