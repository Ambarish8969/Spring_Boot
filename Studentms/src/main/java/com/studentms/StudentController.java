package com.studentms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("/")
	public String home() {
		return "<h1>Welcome Ambi</>";
	}

}
