package com.employee.service;

import java.util.List;

import com.employee.module.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee e);

	Employee getById(Integer eid);

	List<Employee> getByLessSal(Double sal);

	List<Employee> getByDesignation(String designation);

	Employee updateEmployee(Employee e);

	void deleteEmpById(Integer eid);

}
