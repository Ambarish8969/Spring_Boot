package com.employeems.service;

import java.util.List;

import com.employeems.module.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee e);
	
	List<Employee> getEmployees();
	
	Employee getEmployeeById(Integer eid);
	
	void deleteEmployee(Integer eid);
	
	Employee updateEmployee(Integer eid,Employee e);
	
	List<Employee> employeeWithMoreSal();
	
	void deleteAllEmployees();
}
