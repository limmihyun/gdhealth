package com.tree.gdhealth.headoffice.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/headoffice/home")
@Controller
public class HomeController {
	
	@GetMapping
	public String home() {
		
		return "headoffice/home";
	}
	
}
