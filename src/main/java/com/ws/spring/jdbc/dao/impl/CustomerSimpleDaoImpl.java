package com.ws.spring.jdbc.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.ws.spring.jdbc.dao.CustomerDao;
import com.ws.spring.jdbc.model.CustomerModel;

public class CustomerSimpleDaoImpl extends SimpleJdbcDaoSupport implements
		CustomerDao {

	@Override
	public void insert(CustomerModel customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerModel findByCustomerId2(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public CustomerModel findByCustomerId(int customerId) {
		String sql = "select * from customer where cust_id = ?";
		CustomerModel customerModel = getSimpleJdbcTemplate().queryForObject(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(CustomerModel.class), customerId);
		return customerModel;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<CustomerModel> findAll(int cust_id) {
		String sql = "select * from customer where cust_id = ?";
		List<CustomerModel> customerModels = getSimpleJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(CustomerModel.class),cust_id);
		return customerModels;
	}

	@Override
	public String findCustomerNameById(int cust_id) {
		String sql = "select name from customer where cust_id = ?";
		String name = getSimpleJdbcTemplate().queryForObject(sql, String.class, cust_id);
		return name;
	}
	
	public int findTotalCustomer(){
		String sql = "SELECT COUNT(*) FROM CUSTOMER";
		int total = getSimpleJdbcTemplate().queryForInt(sql);
		return total;
	}
}
