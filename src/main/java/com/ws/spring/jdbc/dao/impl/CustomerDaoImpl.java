package com.ws.spring.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;




import com.ws.spring.jdbc.dao.CustomerDao;
import com.ws.spring.jdbc.model.CustomerModel;

public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao {

	// private DataSource dataSource;
	// private JdbcTemplate jdbcTemplate;
	// public void setDataSource(DataSource dataSource) {
	// this.dataSource = dataSource;
	// }

	@Override
	public void insert(CustomerModel customer) {
		String sql = "INSERT INTO customer "
				+ "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		// jdbcTemplate = new JdbcTemplate(dataSource);
		// jdbcTemplate.update(sql, new Object[] {customer.getCustomerId(),
		// customer.getName(),customer.getAge()
		// });

		// JdbcDaoSupport
		getJdbcTemplate().update(
				sql,
				new Object[] { customer.getCustomerId(), customer.getName(),
						customer.getAge() });
	};

	public CustomerModel findByCustomerId2(String name) {
		String sql = "select * from customer where name = ?";
		CustomerModel customer = (CustomerModel)getJdbcTemplate().queryForObject(sql,
				new String[] { name },
				new BeanPropertyRowMapper(CustomerModel.class));
		
		return customer;
	}

	// @Override
	// public void insert(CustomerModel customer) {
	// String sql = "INSERT INTO customer " +
	// "(CUST_ID, NAME, AGE) VALUES ('"+
	// customer.getCustomerId()+"','"+
	// customer.getName()+"','"+
	// customer.getAge()+"')";
	// Connection conn = null;
	// try {
	// conn = dataSource.getConnection();
	// Statement stmt = conn.createStatement() ;
	// int rows = stmt.executeUpdate(sql);
	// System.out.println("sqlִ��:"+rows);
	// stmt.close();
	// }catch (SQLException e) {
	// e.printStackTrace();
	//
	// }finally {
	// if(conn != null){
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// }

	@Override
	public CustomerModel findByCustomerId(int customerId) {
		return null;
	}

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			// 2.使用DriverManager获取数据库连接，其中返回的Connection就代表了Java程序和数据库的连接
			// 不同数据库的URL写法需要查看驱动文档，用户名、密码由DBA分配
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.1.105:3306/test01", "root", "root");
			// 3.使用Connection来创建一个Statement对象
			Statement stmt = conn.createStatement();
			// 4.执行SQL语句
			// Statement有三种执行SQL语句的方法
			ResultSet rs = stmt.executeQuery("select * from customer");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<CustomerModel> findAll(int cust_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findCustomerNameById(int cust_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findTotalCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

}
