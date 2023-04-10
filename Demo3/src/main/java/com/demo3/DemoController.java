package com.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// localhost:8080
@Controller
public class DemoController {
	
	// localhost:8080/display
	@RequestMapping("/display")
	String display() {
		System.out.println("Hii Ambi");
		return "";
	}
	
	// localhost:8080/home
	@RequestMapping("/home")
	String home() {
		System.out.println("Byee");
		return "";
	}
}
