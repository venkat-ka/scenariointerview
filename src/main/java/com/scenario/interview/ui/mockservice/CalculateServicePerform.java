package com.scenario.interview.ui.mockservice;

import org.springframework.beans.factory.annotation.Autowired;

public class CalculateServicePerform{
	
	@Autowired
	public CalculateService caluservice;
	
	
	public CalculateServicePerform() {
		
	}


	public CalculateServicePerform(CalculateService caluservice) {
		this.caluservice = caluservice;
	}


	public int sum(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("is working junit");
		
		return caluservice.sum(i, j)+i;
	}

}
