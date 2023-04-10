package com.demo2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("1")
public class EWIT extends College{
	
	void fee() {
		System.out.println("ewit method");
	}
}
