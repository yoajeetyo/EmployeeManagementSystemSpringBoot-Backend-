package com.ems.emsCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ems.emsCRUD.entity.Employee;
import com.ems.emsCRUD.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repo;
	
	// to get all the Employees
	//localhost:8080/employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> employees =repo.findAll();
		return employees;
	}
	
	// to get specific Employees by employee id
	//localhost:8080/employees/1
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id){
		Employee employee = repo.findById(id).get();
		return employee;
	}
	
	// adding new employee to the database
	//localhost:8080/employee/add
	@PostMapping("/employee/add")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee newEmployee =repo.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
	}
	
	// Updating employees details on the basis of id
	//localhost:8080/employee/update/2
	@PutMapping("/employee/update/{id}")
	public Employee updateEmployees(@PathVariable int id){
		Employee employee = repo.findById(id).get();
		employee.setName("Shyam");
		employee.setSalary(70000.0f);
		repo.save(employee);
		return employee;
	}
	
	// Deleting employees on the basis of id
	//localhost:8080/employee/delete/2
	@DeleteMapping("/employee/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeEmployee(@PathVariable int id){
		Employee employee = repo.findById(id).get();
		repo.delete(employee);
	}

}
