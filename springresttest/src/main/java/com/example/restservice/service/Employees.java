package com.example.restservice.service;

import java.util.List;

import com.example.restservice.entities.Employee;


public interface Employees {
	public List<Employee>getEmployee();
	public Employee getEmployee(Long employee_id);
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	

}