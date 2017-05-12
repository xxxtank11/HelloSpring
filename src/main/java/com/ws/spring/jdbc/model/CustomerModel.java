package com.ws.spring.jdbc.model;

public class CustomerModel {

	int cust_id;
	String name;
	int age;
	
//	public CustomerModel(int cust_id, String name, int age){
//		this.cust_id = cust_id;
//		this.name = name;
//		this.age = age;
//	}
	
	public int getCustomerId() {
		return cust_id;
	}
	public void setCustomerId(int customerId) {
		this.cust_id = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
