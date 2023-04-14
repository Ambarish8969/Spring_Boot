package com.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class WebController {
	@Autowired
	StudentRepo repo;

	@RequestMapping("/")
	String home() {
		return "home.jsp";
	}

	@RequestMapping("/addstudent")
	String addStudent() {
		return "studentform.jsp";
	}

	@ResponseBody
	@RequestMapping("/savestudent")
	String saveStudent(Student s) {
		repo.save(s);
		return "<h2>Student Saved</h2>";
	}

	@RequestMapping("/deletestudents")
	String deleteStudent(Student s) {
		repo.deleteAll();
		return "All Students Deleted Successfully";
	}
	
	@RequestMapping("/studentdetails")
	String getstudentbyid(HttpSession h1,Integer id) {
		Student student=repo.findById(id).orElse(null);
		h1.setAttribute("id", student.getId());
		h1.setAttribute("name", student.getName());
		h1.setAttribute("email", student.getEmail());
		h1.setAttribute("phno", student.getPhno());
		return "studentDetails.jsp";
	}
	
	@RequestMapping("/deletestudent")
	String deletestudentbyid(Integer id) {
		repo.deleteById(id);
		return "deletestudent.jsp";
	}
}
