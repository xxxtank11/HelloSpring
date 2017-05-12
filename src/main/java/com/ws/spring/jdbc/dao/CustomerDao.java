package com.ws.spring.jdbc.dao;


import java.util.List;

import com.ws.spring.jdbc.model.CustomerModel;

public interface CustomerDao {

	public void insert(CustomerModel customer);
	public CustomerModel findByCustomerId2(String name);
	public CustomerModel findByCustomerId(int cust_id);
	public List<CustomerModel> findAll(int cust_id);
	public String findCustomerNameById(int cust_id);
	public int findTotalCustomer();
}
