package com.ws.spring.service;

import javax.naming.Context;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ws.spring.Customer;
import com.ws.spring.aop.CustomerAOP;

public class APP {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"spring-config.xml"});
		OutputGeneratorService outs = (OutputGeneratorService) context
				.getBean("outputGeneratorService");
		outs.generateOutput();

		Customer csCustomer = (Customer) context.getBean("customerBean");
		System.out.println(csCustomer.getPerson().getName());
		//bean作用域
		CustomerService custA = (CustomerService)context.getBean("customerService");
    	custA.setMessage("Message by custA");
    	System.out.println("Message : " + custA.getMessage());
    	
    	//retrieve it again
    	CustomerService custB = (CustomerService)context.getBean("customerService");
    	System.out.println("Message : " + custB.getMessage());
    	//context.close();
    	
    	//spring aop advice
    	/**
    	 * before
    	 * **/
    	CustomerAOP custAopB = (CustomerAOP)context.getBean("customerAopProxy");
    	System.out.println("**************before");
    	custAopB.printName();
    	System.out.println("**************");
    	custAopB.printUrl();
    	System.out.println("**************");
    	/**
    	 * after
    	 * **/
    	CustomerAOP custAopA = (CustomerAOP)context.getBean("customerServiceProxy");
    	System.out.println("**************after");
    	custAopA.printName();
    	System.out.println("**************");
    	custAopA.printUrl();
    	System.out.println("**************");
    	/**
    	 * throw
    	 * **/
//    	CustomerAOP custAopT = (CustomerAOP)context.getBean("ThrowExceptionProxy");
//    	System.out.println("**************throw");
//    	custAopT.printName();
//    	System.out.println("**************");
//    	custAopT.printUrl();
//    	System.out.println("**************");
//    	custAopT.printThrowException();
    	/**
    	 * around method
    	 * **/
//    	CustomerAOP custAopM = (CustomerAOP)context.getBean("aroundMethodProxy");
//    	System.out.println("**************around method");
//    	custAopM.printName();
//    	System.out.println("**************");
//    	custAopM.printUrl();
//    	System.out.println("**************");
    	//custAopM.printThrowException();
    	
    	//spring aop  Advisor
    	CustomerAOP custAopM = (CustomerAOP)context.getBean("customerAopProxy");
    	System.out.println("**************advisor method");
    	custAopM.printName();
    	System.out.println("**************");
    	custAopM.printUrl();
    	System.out.println("**************");
	}

}
