package com.scenario.interview.ui;

import com.scenario.interview.ui.mockservice.CalculateService;
import com.scenario.interview.ui.mockservice.CalculateServicePerform;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCaluculatorService {
	
	CalculateService serviceMock = mock(CalculateService.class);
	CalculateServicePerform c = new CalculateServicePerform(serviceMock);;
	
	
	@Before
	public void setUp() {
		c = new CalculateServicePerform(serviceMock);
	}
	
	@After
	public void completedTest() {
		System.out.println("ITest case completed");
	}
	
	
	@Test
	public void testPerfom() {
		when(serviceMock.sum(2,5)).thenReturn(10);
		//System.out.println();
		assertEquals(12, c.sum(2, 5));
		verify(serviceMock).sum(2,5);
	}
}
