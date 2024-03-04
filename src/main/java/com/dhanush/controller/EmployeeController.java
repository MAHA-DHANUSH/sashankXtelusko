package com.dhanush.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dhanush.dto.EmployeeTO;
import com.dhanush.model.Employee;
import com.dhanush.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createEmployee(@RequestBody EmployeeTO emp) {
		return employeeService.createEmployee(emp);
	}
	
	@GetMapping("/get")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getEmployee()
	{
		return employeeService.getEmployee();
	}
	
	@GetMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public String deleteEmployee(@RequestParam String id)
	{
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public String updateEmployee(@RequestBody EmployeeTO emp) {
		return employeeService.updateEmployee(emp);
	}
}
