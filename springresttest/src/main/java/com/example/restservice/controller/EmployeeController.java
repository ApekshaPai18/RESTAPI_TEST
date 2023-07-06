package com.example.restservice.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.entities.Employee;
import com.example.restservice.service.Employees;





@RestController
public class EmployeeController {
	@Autowired
	private Employees employees;
	
	
	
	

	//get the courses
	
		@GetMapping("/employees")
		public List<Employee> getEmployee()
		{
			return this.employees.getEmployee();
			
			
		}

		//get the course by particular id
		@GetMapping("/employees/{employee_id}")
		public  Employee getEmployee(@PathVariable String employee_id) {
			return this.employees.getEmployee((Long.parseLong(employee_id)));
		}
		
		//post the course
		@PostMapping("/employees")
		public  Employee addEmployee(@RequestBody Employee employee) {
			return this.employees.addEmployee(employee);
		}
		
		
		//update
		@PutMapping("/employees")
		public  Employee updateEmployee(@RequestBody Employee employee) {
			return this.employees.updateEmployee(employee);
		}
		
		
		//delete
		@DeleteMapping("/employees/{employee_id}")
		public ResponseEntity<HttpStatus>deleteEmployee(Employee employee){
			try {
				this.employees.deleteEmployee(employee);
			
		return new ResponseEntity<>(HttpStatus.OK);
	    }catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
		
	}

