package com.demo4;

import java.util.List;

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

	@RequestMapping("/savestudent")
	String saveStudent(Student s) {
		repo.save(s);
		return "studentform.jsp";
	}

	@RequestMapping("/deletestudents")
	String deleteStudent(Student s) {
		repo.deleteAll();
		return "All Students Deleted Successfully";
	}

	@RequestMapping("/studentdetails")
	String getstudentbyid(HttpSession h1, Integer id) {
		Student student = repo.findById(id).orElse(null);
		if (student != null) {
			h1.setAttribute("id", student.getId());
			h1.setAttribute("name", student.getName());
			h1.setAttribute("email", student.getEmail());
			h1.setAttribute("phno", student.getPhno());
			return "studentDetails.jsp";
		} else {
			return "errorpage.jsp";
		}

	}
	
	@RequestMapping("/getallstudents")
	String getallstudents(HttpSession h1,Student s) {
		List<Student> list=(List<Student>) repo.findAll();
		h1.setAttribute("students", list);
		return "allstudents.jsp";
	}

	@RequestMapping("/deletestudent")
	String deletestudentbyid(Integer id) {
		Student student = repo.findById(id).orElse(null);
		if (student != null) {
			repo.deleteById(id);
			return "deletestudent.jsp";
		} else {
			return "errorpage.jsp";
		}
	}
	
	@ResponseBody
	@RequestMapping("/getbyemail")
	List<Student> getByEmail(String email) {
		List<Student> emails= repo.findByEmail(email);
		return emails;
	}
	
	@ResponseBody
	@RequestMapping("/sortbyphno")
	List<Student> sortByPhno(){
		List<Student> phnos=repo.findByPhno();
		return phnos;
	}
	
	@ResponseBody
	@RequestMapping("/getbyname")
	List<Student> getByName(String name){
		List<Student> names=repo.findByName(name);
		return names;
	}
}
