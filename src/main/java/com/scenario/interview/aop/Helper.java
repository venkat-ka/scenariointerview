package com.scenario.interview.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Helper {

	@Before(value="execution(public * com.scenario.interview.ui.restcontroller.FrontController.insertRow())")
	public void log(JoinPoint joinpoint) {
		System.out.println("get Before feed  insertRow called "+joinpoint.getSignature().getName());
	}
	
	
	@After(value="execution(public * com.scenario.interview.ui.restcontroller.FrontController.insertRow())")
	public void logAft(JoinPoint joinpoint) {
		System.out.println("get After feed  insertRow called "+joinpoint.getSignature().getName());
	}
	
	
	@Before(value="execution(* com.scenario.interview.ui.restcontroller.FrontController.*(..))")
	public void logRest(JoinPoint joinpoint) {
		System.out.println("getValidate call "+joinpoint.getSignature().getName());
	}
	
	
}
