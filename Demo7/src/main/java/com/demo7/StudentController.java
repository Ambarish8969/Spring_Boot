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
}
