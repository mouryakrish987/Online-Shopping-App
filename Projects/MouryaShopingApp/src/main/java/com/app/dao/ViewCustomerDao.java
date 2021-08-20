package com.app.dao;

import java.util.List;

import com.app.model.Customers;

public interface ViewCustomerDao {
	public List<Customers> viewCustomerById(int id);
	public List<Customers> viewCustomerByName(String name);
	public List<Customers> viewCustomerByemail(String email);
	public List<Customers> viewCustomerByPhoneNo(String phoneNo);
}
