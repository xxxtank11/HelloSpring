package com.ws.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Customer {

	private Person person;
	private int type;
	private String action;
	public Person getPerson() {
		return person;
	}
	@Autowired
	@Required
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	
	public void setAction(String actionString) {
		this.action = actionString;
	}
	
	public void initIt(){
		System.out.println("init:"+type);
	}
	
	public void cleanUp(){
		System.out.println("cleanup!");
	}
}
