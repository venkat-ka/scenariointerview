package com.scenario.interview.ui.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/springQnA")
@RestController
public class SpringBoorIntQnA {
	
	@GetMapping("/theory")
	public Map<String, String> getSpringReqlQnA(){
		
		Map<String, String> qNaLists = new HashMap<>();
		qNaLists.put("Q", "what are the Spring boot feature not present in Spring?");
		qNaLists.put("A", "1) Starter POM. "
				+ " 2) Auto COnfiguration"
				+ " 3) Component Scanning"
				+ " 4) Embeded Server"
				+ " 5) InMemory Database"
				+ " 6) Actuator");
		
		return qNaLists;
	}
}
