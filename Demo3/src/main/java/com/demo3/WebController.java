package com.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class WebController {

	@RequestMapping("/webapp1")
	String webapp1() {
		return "home.jsp";
	}

	@RequestMapping("/student1")
	String student1(HttpSession h1, Student s) {
		h1.setAttribute("student", s);
		return "home.jsp";
	}

	@RequestMapping("employee")
	String employee(HttpSession h1, Employee e) {
		h1.setAttribute("employee", e);
		return "home.jsp";
	}

}
