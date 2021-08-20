package com.app.service;

import java.util.List;

import com.app.model.Customers;

public interface ViewCustomerService {
	public List<Customers> viewCustomerById(int id);
	public List<Customers> viewCustomerByName(String name);
	public List<Customers> viewCustomerByemail(String email);
	public List<Customers> viewCustomerByPhoneNo(String phoneNo);
}
