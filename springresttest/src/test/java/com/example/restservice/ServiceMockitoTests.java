package com.example.restservice;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restservice.dao.EmployeeDao;
import com.example.restservice.entities.Employee;
import com.example.restservice.service.EmployeeManager;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes= {ServiceMockitoTests.class})
public class ServiceMockitoTests {
	
	
	
	@Mock
	EmployeeDao employeerep;
	
	@InjectMocks
	EmployeeManager employeeManager;
	
	public List<Employee>employees;
	
	@Test
	@Order(1)
	public void test_getEmployee() {
		List<Employee>employees=new ArrayList<Employee>();
		employees.add(new Employee(1,"Kakashi","Hatake","kakashi@gmail.com","CEO"));
		employees.add(new Employee(2,"Naruto","Uzumaki","naruto@gmail.com","manager"));
		
		when(employeerep.findAll()).thenReturn(employees);
		assertEquals(2,employeeManager.getEmployee().size());
		
	}
	@Test
	@Order(2)
	public void t_getEmployee() {
		List<Employee>employees=new ArrayList<Employee>();
		employees.add(new Employee(1,"Kakashi","Hatake","kakashi@gmail.com","CEO"));
		employees.add(new Employee(2,"Naruto","Uzumaki","naruto@gmail.com","manager"));
		long employeeId=1;
		when(employeerep.findAll()).thenReturn(employees);
		assertEquals(1,employeeManager.getEmployee(employeeId).getEmployee_id());
		
	}
	
	@Test
	@Order(3)
	public void test_addEmployee() {
		Employee employee=new Employee(3,"Itachi","Uchiha","itachi@gmail.com","staff");
		when(employeerep.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeManager.addEmployee(employee));
	}
	
	@Test
	@Order(4)
	public void test_updateEmployee() {
		Employee employee=new Employee(3,"Itachi","Uchiha","itachi@gmail.com","staff");
		when(employeerep.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeManager.updateEmployee(employee));
		
	}
	
	@Test
	@Order(5)
	public void test_deleteEmployee() {
		Employee employee=new Employee(3,"Itachi","Uchiha","itachi@gmail.com","staff");
		
		employeeManager.deleteEmployee(employee);
		
		verify(employeerep,times(1)).delete(employee);
		
	}
	

}
