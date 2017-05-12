package com.ws.spring.service;

import javax.naming.Context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ws.spring.aop.CustomerAOP;
import com.ws.spring.aop.CustomerBo;

public class AopExampel {

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				new String[] {"spring-aop-config.xml"});
//		CustomerAOP custA = (CustomerAOP)context.getBean("customerAOP");
//		System.out.println("**************advisor method");
//		custA.printName();
//    	System.out.println("**************");
//    	custA.printUrl();
//    	System.out.println("**************");
    	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"spring-aop-aspectj.xml"});
    	CustomerBo custB = (CustomerBo)context.getBean("customerBo");
    	custB.addCustomer();
	}
}
