package com.employee.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.employee.module.Employee;
import com.employee.service.EmployeeService;

// @RestController is combination of @Controller and @ResponseBody( @Controller + @ResponseBody = @RestController).
@RestController
public class EmployeeController {

	// @PostMapping --> Insert
	// @GetMapping --> Access
	// @DeleteMapping --> Delete
	// @PutMapping --> Update

	@Autowired
	EmployeeService service;

	@PostMapping("/addemployee")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
		return new ResponseEntity<Employee>(service.addEmployee(e), HttpStatus.CREATED);
	}

	@GetMapping("/empbyid")
	ResponseEntity<Employee> getById(@RequestHeader Integer eid) {
		return new ResponseEntity<Employee>(service.getById(eid), HttpStatus.FOUND);
	}

	@GetMapping("/empbydesignation")
	ResponseEntity<List<Employee>> getByDesignation(@RequestHeader String designation) {
		return new ResponseEntity<List<Employee>>(service.getByDesignation(designation), HttpStatus.FOUND);
	}

	@GetMapping("/empbysal")
	ResponseEntity<List<Employee>> getByLessSal(@RequestHeader Double sal) {
		return new ResponseEntity<List<Employee>>(service.getByLessSal(sal), HttpStatus.FOUND);
	}

	@PutMapping("/updateemp")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) {
		return new ResponseEntity<Employee>(service.updateEmployee(e), HttpStatus.OK);
	}

	@DeleteMapping("/deleteemp")
	ResponseEntity<Void> deleteEmpById(@RequestHeader Integer eid) {
		service.deleteEmpById(eid);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
