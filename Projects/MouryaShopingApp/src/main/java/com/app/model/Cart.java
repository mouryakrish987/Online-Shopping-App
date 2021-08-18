package com.app.model;

public class Cart {
	private int cartid;
	private int productid;
	private int customerid;
	public Cart(int cartid, int productid, int customerid) {
		super();
		this.cartid = cartid;
		this.productid = productid;
		this.customerid = customerid;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
	
}
