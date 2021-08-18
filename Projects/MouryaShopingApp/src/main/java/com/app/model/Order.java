package com.app.model;

public class Order {
	private int orderid;
	private String orderStatus;
	private int customerid;
	private int productid;
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderStatus=" + orderStatus + ", customerid=" + customerid
				+ ", productid=" + productid + "]";
	}
	public Order(int orderid, String orderStatus, int customerid, int productid) {
		super();
		this.orderid = orderid;
		this.orderStatus = orderStatus;
		this.customerid = customerid;
		this.productid = productid;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
}
