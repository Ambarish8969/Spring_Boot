package com.employeems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employeems.module.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query(value = "select * from employee where esalary>=50000", nativeQuery = true)
	List<Employee> employeeWithMoreSal();
}
