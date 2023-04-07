package com.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype") // to create multiple objects.
public class Student {
	@Autowired // dependency injection
	College c;
	
	Student() {
		System.out.println("Hii ambi");
	}

	void display() {
		System.out.println("Hello Students");
		c.fee();
	}
}
