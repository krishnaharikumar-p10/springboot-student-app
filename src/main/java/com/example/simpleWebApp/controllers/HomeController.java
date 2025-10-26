package com.example.simpleWebApp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String greeting() {
		return " Welcome to SpringBoot";
	}
	
	@RequestMapping("/about")
	public String about() {
		return " We learn";
	}
}
