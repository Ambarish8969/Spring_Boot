package com.hello;

import org.springfraamework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Hello {
	@RequestMapping("/hello")
	public String hello() {
		return "Hello";
	}
}
