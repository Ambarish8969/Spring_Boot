package com.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	@RequestMapping("studentform")
	String form() {
		return "form.jsp";
	}
	
	@RequestMapping("student2")
	String student2(HttpSession h2, Student s) {
		h2.setAttribute("sid", s.getSid());
		h2.setAttribute("sname", s.getSname());
		return "student.jsp";
	}
}
