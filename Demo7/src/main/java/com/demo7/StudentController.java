package com.demo7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	
	@ResponseBody
	@RequestMapping("/home")
	public String home() {
		return "<h1>Home Page</h1>";
	}
	
	// Add Student...
	@RequestMapping("/addstudent")
	public String addStudent() {
		return "addstudent.jsp";
	}
	
	@RequestMapping("/savestudent")
	public String saveStudent(HttpSession h1,Student s) {
		h1.setAttribute("id", s.getId());
		h1.setAttribute("name", s.getName());
		h1.setAttribute("marks", s.getMarks());
		repo.save(s);
		return "addstudent.jsp";
	}
	
	// Delete Student...
	@RequestMapping("/deletestudent")
	public String deleteform() {
		return "deletestudent.jsp";
	}
	
	@RequestMapping("/studentdeleted")
	public String deleteStudent(HttpSession h1,Integer id) {
		Student student=repo.findById(id).orElse(null);
		if(student != null) {
			repo.deleteById(id);
			return "deletestudent.jsp";
		}else {
			return "home.jsp";
		}
	}
	
	// Get Student...
	@RequestMapping("/getstudent")
	public String details() {
		return "getdetails.jsp";
	}
	
	@RequestMapping("/studentdetails")
	public String studentDetails(HttpSession h1,Integer id) {
		Student student=repo.findById(id).orElse(null);
		if(student != null) {
			h1.setAttribute("id", student.getId());
			h1.setAttribute("name", student.getName());
			h1.setAttribute("marks", student.getMarks());
			return "studentdetails.jsp";
		}else {
			throw new ResourceNotFoundException("Student", "Id", student.getId());
		}
	}
	
	// Update Student...
	@RequestMapping("/update")
	public String update() {
		return "updatebyid.jsp";
	}
	
	@RequestMapping("/updatestudent")
	public String updateStudent(HttpSession h1,Integer id) {
		Student student=repo.findById(id).orElse(null);
		if(student != null) {
			h1.setAttribute("id", student.getId());
			h1.setAttribute("name", student.getName());
			h1.setAttribute("marks", student.getMarks());
			return "updatestudent.jsp";
		}else {
			throw new ResourceNotFoundException("Student", "Id", student.getId());
		}
	}
}
