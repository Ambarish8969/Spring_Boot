package com.studentdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.studentdb.module.Student;
import com.studentdb.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/addstudent")
	ResponseEntity<Student> addStudent(@RequestBody Student s) {
		return new ResponseEntity<Student>(service.addStudent(s), HttpStatus.CREATED);
	}

	@GetMapping("/getstudent")
	ResponseEntity<Student> getStudent(@RequestHeader Integer sid) {
		return new ResponseEntity<Student>(service.getStudent(sid), HttpStatus.FOUND);
	}

	@PutMapping("/updatestudent")
	ResponseEntity<Student> updateStudent(@RequestBody Student s) {
		return new ResponseEntity<Student>(service.updateStudent(s), HttpStatus.OK);
	}

	@DeleteMapping("/deletestudent")
	ResponseEntity<Void> deleteStudent(@RequestHeader Integer sid){
		service.deleteStudent(sid);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getallstudents")
	ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(service.getAllStudent(),HttpStatus.FOUND);
	}
	
	@GetMapping("/getstudentsbymarks")
	ResponseEntity<List<Student>> getStudentByMarks(@RequestHeader Integer marks){
		return new ResponseEntity<List<Student>>(service.getStudentByMarks(marks),HttpStatus.FOUND);
	}
}
