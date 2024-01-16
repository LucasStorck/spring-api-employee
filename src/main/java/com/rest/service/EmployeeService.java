package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.Employee;
import com.rest.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	public Employee createEmployee(Employee emp) {
		return empRepository.save(emp);
	}
	
	public List<Employee> getEmployee(){
		return empRepository.findAll();
	}
	
	public Employee updateEmployee(Long empId, Employee employeeDetails) {
		Employee emp = empRepository.findById(empId).get();
		emp.setFirstName(employeeDetails.getFirstName());
		emp.setLastName(employeeDetails.getLastName());
		emp.setEmp_email(employeeDetails.getEmp_email());
		emp.setEmp_age(employeeDetails.getEmp_age());
		
		return empRepository.save(emp);
	}
	
	public void deleteEmployee(Long empId) {
		empRepository.deleteById(empId);
	}
}
