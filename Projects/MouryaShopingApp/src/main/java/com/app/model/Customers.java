package com.app.model;

public class Customers {
	private int customerid;
	private String Name;
	private String email;
	private String password;
	private String phoneNo;
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customers(int customerid, String name, String email, String password, String phoneNo) {
		super();
		this.customerid = customerid;
		Name = name;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "Customers [customerid=" + customerid + ", Name=" + Name + ", email=" + email + ", password=" + password
				+ ", phoneNo=" + phoneNo + "]";
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
}
