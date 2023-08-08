package com.employeems.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeems.exceptions.EmployeeNotFoundException;
import com.employeems.module.Employee;
import com.employeems.repo.EmployeeRepo;
import com.employeems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo repo;

	@Override
	public Employee addEmployee(Employee e) {
		
		return repo.save(e);
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees=repo.findAll();
		return employees;
	}

	@Override
	public Employee getEmployeeById(Integer eid) {
		
		return repo.findById(eid).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id : "+eid)); 
	}

	@Override
	public void deleteEmployee(Integer eid) {
		repo.deleteById(eid); 
		
	}

	@Override
	public Employee updateEmployee(Integer eid,Employee e) {
		Employee e1 = repo.findById(eid).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id : "+eid));
		if (e1 != null) {
			e1.setEname(e.getEname());
			e1.setEage(e.getEage());
			e1.setEsalary(e.getEsalary());
			return repo.save(e1);
		}else {
			throw new EmployeeNotFoundException("Employee not found.");
		}
	}
	
	@Override
	public List<Employee> employeeWithMoreSal(){
		List<Employee> employees=repo.employeeWithMoreSal();
		return employees;
	}
	
	@Override
	public void deleteAllEmployees() {
		repo.deleteAll();
	}

}
