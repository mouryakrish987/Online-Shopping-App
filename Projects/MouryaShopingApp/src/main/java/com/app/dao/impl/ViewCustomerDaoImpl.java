package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ViewCustomerDao;
import com.app.model.Customers;
import com.app.utlity.JavaDbConnection;

public class ViewCustomerDaoImpl  implements ViewCustomerDao{
	private static Logger log = Logger.getLogger(ViewCustomerDaoImpl.class);
	@Override
	public List<Customers> viewCustomerById(int id) {
		List<Customers> customerList = new ArrayList<>();
		try(Connection connection = JavaDbConnection.getConnection()){
			String sql="Select * from Customer where customerid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultset= preparedStatement.executeQuery();
			while(resultset.next()) {
				// customerid, name, email, password, phoneNo
				Customers customer = new Customers();
				customer.setCustomerid(resultset.getInt("customerid"));
				customer.setName(resultset.getString("name"));
				customer.setEmail(resultset.getString("email"));
				customer.setPassword(resultset.getString("password"));
				customer.setPhoneNo(resultset.getString("phoneNo"));
				customerList.add(customer);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal error occues please contact suport team");
		}
		return customerList;
	}

	@Override
	public List<Customers> viewCustomerByName(String name) {
		List<Customers> customerList = new ArrayList<>();
		try(Connection connection = JavaDbConnection.getConnection()){
			String sql="Select * from Customer where name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultset= preparedStatement.executeQuery();
			while(resultset.next()) {
				// customerid, name, email, password, phoneNo
				Customers customer = new Customers();
				customer.setCustomerid(resultset.getInt("customerid"));
				customer.setName(resultset.getString("name"));
				customer.setEmail(resultset.getString("email"));
				customer.setPassword(resultset.getString("password"));
				customer.setPhoneNo(resultset.getString("phoneNo"));
				customerList.add(customer);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal error occues please contact suport team");
		}	
		return customerList;
	}

	@Override
	public List<Customers> viewCustomerByemail(String email) {
		List<Customers> customerList = new ArrayList<>();
		try(Connection connection = JavaDbConnection.getConnection()){
			String sql="Select * from Customer where email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultset= preparedStatement.executeQuery();
			while(resultset.next()) {
				// customerid, name, email, password, phoneNo
				Customers customer = new Customers();
				customer.setCustomerid(resultset.getInt("customerid"));
				customer.setName(resultset.getString("name"));
				customer.setEmail(resultset.getString("email"));
				customer.setPassword(resultset.getString("password"));
				customer.setPhoneNo(resultset.getString("phoneNo"));
				customerList.add(customer);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal error occues please contact suport team");
		}
		return customerList;
	}

	@Override
	public List<Customers> viewCustomerByPhoneNo(String phoneNo) {
		List<Customers> customerList = new ArrayList<>();
		try(Connection connection = JavaDbConnection.getConnection()){
			String sql="Select * from Customer where phoneNo=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phoneNo);
			ResultSet resultset= preparedStatement.executeQuery();
			while(resultset.next()) {
				// customerid, name, email, password, phoneNo
				Customers customer = new Customers();
				customer.setCustomerid(resultset.getInt("customerid"));
				customer.setName(resultset.getString("name"));
				customer.setEmail(resultset.getString("email"));
				customer.setPassword(resultset.getString("password"));
				customer.setPhoneNo(resultset.getString("phoneNo"));
				customerList.add(customer);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal error occues please contact suport team");
		}
		return customerList;
	}

}
