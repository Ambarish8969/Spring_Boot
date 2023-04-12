package com.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index") // we can create multiple controllers in one project.
public class TestController {

	// localhost:8080/index/home2
	@RequestMapping("/home2")
	String home2() {
		System.out.println("index.home2");
		return "";
	}
	
	@ResponseBody // used to print the "return" statement in browser.
	@RequestMapping("/home3") // localhost:8080/index/home2
	String home3() {
		System.out.println("index.home3");
		return "<h3>Ambika</h3>";
	}
	
	@ResponseBody
	@RequestMapping("/home4")
	String home4(String name) {
		return "Hii : "+name;
	}
	
	@ResponseBody
	@RequestMapping("/home5")
	String home5(String input) {
		return "<h1>Hii "+input+" how are you?</h1>";
	}

	 
}
