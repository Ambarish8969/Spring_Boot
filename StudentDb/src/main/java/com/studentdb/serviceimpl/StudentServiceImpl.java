package com.studentdb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentdb.exceptions.ResourceNotFoundException;
import com.studentdb.module.Student;
import com.studentdb.repo.StudentRepo;
import com.studentdb.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo repo;

	@Override
	public Student addStudent(Student s) {
		return repo.save(s);
	}

	@Override
	public Student updateStudent(Student s) {
		Student student = repo.findById(s.getSid()).orElse(null);
		if (student != null) {
			student.setSid(s.getSid());
			student.setSname(s.getSname());
			student.setMarks(s.getMarks());
			return repo.save(student);
		} else {
			throw new ResourceNotFoundException("Student", "Id", s.getSid());
		}
	}

	@Override
	public Student getStudent(Integer sid) {
		return repo.findById(sid).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", sid));
	}

	@Override
	public void deleteStudent(Integer sid) {
		repo.deleteById(sid);
	}

}
