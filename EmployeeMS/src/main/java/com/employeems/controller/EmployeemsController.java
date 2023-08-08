package com.employeems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeems.module.Employee;
import com.employeems.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3008")
public class EmployeemsController {

	@Autowired
	EmployeeService service;

	@PostMapping("/addemployee")
	public void addemployee(@RequestBody Employee e) {
		Employee employee=service.addEmployee(e);
	}

	@GetMapping("/getemployees")
	public List<Employee> getemployees() {
		List<Employee> employees = service.getEmployees();
		return employees;
	}
	
	@GetMapping("/getemployeebyid/{eid}")
	public Employee getemployeebyid(@PathVariable Integer eid) {
		return service.getEmployeeById(eid);
	}
	
	@PutMapping("/updateemployee/{eid}")
	public Employee updateemployee(@PathVariable Integer eid,@RequestBody Employee e) {
		return service.updateEmployee(eid, e);
	}
	
	@DeleteMapping("/deleteemployee/{eid}")
	public void deleteemployee(@PathVariable Integer eid) {
		service.deleteEmployee(eid);
	}
	
	@GetMapping("/employeewithmoresalary")
	public List<Employee> employeemoresalary(){
		return service.employeeWithMoreSal();
	}
	
	@DeleteMapping("/deleteallemployees")
	public void deleteallemployees() {
		service.deleteAllEmployees();
	}
}
