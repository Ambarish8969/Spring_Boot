package com.demo2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class College {
	void fee() {
		System.out.println("College Fee");
	}
}
