package com.studentdb.service;

import java.util.List;

import com.studentdb.module.Student;

public interface StudentService {
	Student addStudent(Student s);
	
	Student updateStudent(Student s);
	
	Student getStudent(Integer sid);
	
	void deleteStudent(Integer sid);
	
	List<Student> getAllStudent();
	
	List<Student> getStudentByMarks(Integer marks);
}
