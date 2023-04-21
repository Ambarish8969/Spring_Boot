package com.studentdb.service;

import com.studentdb.module.Student;

public interface StudentService {
	Student addStudent(Student s);
	
	Student updateStudent(Student s);
	
	Student getStudent(Integer sid);
	
	void deleteStudent(Integer sid);
}
