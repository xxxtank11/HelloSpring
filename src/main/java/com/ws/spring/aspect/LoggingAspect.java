package com.ws.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



@Aspect
public class LoggingAspect {

	@Before("execution(* com.ws.spring.aop.CustomerBo.addCustomer(..))")
	public void logBefore() {

		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " );
		System.out.println("******");
	}

}
