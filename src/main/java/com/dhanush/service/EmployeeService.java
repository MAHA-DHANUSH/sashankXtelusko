package com.dhanush.service;	

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Builder;


import com.dhanush.dto.EmployeeTO;
import com.dhanush.model.Employee;
import com.dhanush.repository.EmployeeRepository;

@Builder
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String createEmployee(EmployeeTO employeeTO)
	{
		try {
			Employee emp=Employee.builder()
					.empName(employeeTO.getEmpName())
					.salary(employeeTO.getSalary())
					.location(employeeTO.getLocation())
					.build();
			employeeRepository.save(emp);
			
		} catch (Exception e) {
			
		}
		return "Employee Created Succesfully";
	}
	
	public List<Employee> getEmployee()
	{
		List<Employee> empList=new ArrayList<>();
		try {
		empList=employeeRepository.findAll();
			
		} catch (Exception e) {
			
		}
		return empList;
	}

	public String deleteEmployee(String id) {
	    try {
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            employeeRepository.deleteById(id);
	            return "Employee Deleted Successfully";
	        } else {
	            return "Employee Not Found";
	        }
	    } catch (Exception e) {
	      
	        return "An error occurred while deleting the employee";
	    }
	}

	public String updateEmployee(EmployeeTO emp) {
		
		try {
			Employee employee=Employee.builder()
					.id(emp.getId())
					.empName(emp.getEmpName())
					.location(emp.getLocation())
					.salary(emp.getSalary())
					.build();
			employeeRepository.save(employee);
			
		} catch (Exception e) {
			
		}
		return "Employee updated";
	}
}
