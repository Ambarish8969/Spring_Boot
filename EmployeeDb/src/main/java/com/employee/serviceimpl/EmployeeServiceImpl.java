package com.employee.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exceptions.ResourceNotFoundException;
import com.employee.module.Employee;
import com.employee.repo.EmployeeRepo;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo repo;

	@Override
	public Employee addEmployee(Employee e) {

		return repo.save(e);
	}

	@Override
	public Employee getById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public List<Employee> getByLessSal(Double sal) {
		return repo.findByLessSal(sal);
	}

	@Override
	public List<Employee> getByDesignation(String designation) {
		return repo.findByDesignation(designation);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		Employee e1 = repo.findById(e.getEid()).orElse(null);
		if (e1 != null) {
			e1.setEname(e.getEname());
			e1.setDesignation(e.getDesignation());
			e1.setPhno(e.getPhno());
			e1.setSal(e.getSal());
			return repo.save(e1);
		} else {
			throw new ResourceNotFoundException("Employee", "id", e.getEid());
		}
	}

	@Override
	public void deleteEmpById(Integer eid) {
		Employee e1 = repo.findById(eid).orElse(null);
		if (e1 != null) {
			repo.deleteById(eid);
		} else {
			throw new ResourceNotFoundException("Employee", "id", eid);
		}

	}

}
