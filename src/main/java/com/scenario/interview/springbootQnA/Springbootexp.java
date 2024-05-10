package com.scenario.interview.springbootQnA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/spring-boot")
@RestController
public class Springbootexp {
	
	@GetMapping("/achevioc")
	public String springAchIoC() {
		return "we can achieve IOC in Strategy Pattern, Service Locator Pattern"
				+ "Factory Pattern and Dependency Injectionpattern";
	}
	
	@GetMapping("/defioc")
	public String DefIoC() {
		return "IOC is a principle in software engeenering. It transfer the control of"
				+ "Object or portion of program to a container or framework. We often use it in"
				+ "the context of object oriented programming ";
	}
	
	@GetMapping("/springioc_cont")
	public String springIoCCont() {
		return null;
	}
}
