package com.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/webapp1")
	String webapp1() {
		return "home.jsp";
	}
}
