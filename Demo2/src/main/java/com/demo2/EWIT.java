package com.demo2;

import org.springframework.stereotype.Component;

@Component
public class EWIT extends College{
	@Override
	void fee() {
		System.out.println("ewit method");
	}
}
