package com.demo2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("2")
public class Rv extends College{
	void fee() {
		System.out.println("Rv fee.");
	}
}
