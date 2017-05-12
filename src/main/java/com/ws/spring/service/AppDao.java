package com.ws.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ws.spring.jdbc.dao.CustomerDao;
import com.ws.spring.jdbc.model.CustomerModel;

public class AppDao {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc-module.xml");
		CustomerDao customerDao = (CustomerDao)context.getBean("customerDao");
		CustomerModel customerModel = customerDao.findByCustomerId2("a");
		System.out.println(customerModel.getCustomerId());
	}
}
