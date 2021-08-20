package com.app.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ViewCustomerDao;
import com.app.dao.impl.ViewCustomerDaoImpl;
import com.app.main.MainApp;
import com.app.model.Customers;
import com.app.service.ViewCustomerService;

public class ViewCustomerServiceImpl implements ViewCustomerService{
	private static Logger log= Logger.getLogger(MainApp.class);
	ViewCustomerDao vcd= new ViewCustomerDaoImpl();
	@Override
	public List<Customers> viewCustomerById(int id) {
		List<Customers> customerList = null;
		if(id>0) {
			customerList=vcd.viewCustomerById(id);
		}
		else {
			log.info("Invalid id");
		}
		return customerList;
	}

	@Override
	public List<Customers> viewCustomerByName(String name) {
		List<Customers> customerList = null;
		if(name.matches("[a-zA-Z]{2,25}")) {
			customerList = vcd.viewCustomerByName(name);
		}
		else {
			log.info("Invalid name entry");
		}
		return customerList;
	}

	@Override
	public List<Customers> viewCustomerByemail(String email) {
		List<Customers> customerList = null;
		if(email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			customerList = vcd.viewCustomerByemail(email);
		}
		else {
			log.info("invalid mail id");
		}
		return customerList;
	}

	@Override
	public List<Customers> viewCustomerByPhoneNo(String phoneNo) {
		List<Customers> customerList = null;
		if(phoneNo.length()==10) {
			customerList = vcd.viewCustomerByPhoneNo(phoneNo);
		}
		else {
			log.info("invalid phone number");
		}
		return customerList;
	}

	

}
