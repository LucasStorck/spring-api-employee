package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rest.model.Employee;
import com.rest.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee emp) {
	    return empService.createEmployee(emp);
	}
	
	@GetMapping("/employees")
	public List<Employee> readEmployees() {
	    return empService.getEmployee();
	}

	@PutMapping("/employees/{empId}")
	public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
	    return empService.updateEmployee(id, empDetails);
	}

	@DeleteMapping("/employees/{empId}")
	public void deleteEmployees(@PathVariable(value = "empId") Long id) {
	    empService.deleteEmployee(id);
	}
}
