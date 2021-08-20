package com.app.model;

public class Product {
	private int productid;
	private String productName,productType;
	
	public Product(int productid, String productName, String productType, int numberofproducts, double price) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.productType = productType;
		this.numberofproducts = numberofproducts;
		this.price = price;
	}
	private int numberofproducts;
	private double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productName=" + productName + ", productType=" + productType
				+ ", numberofproducts=" + numberofproducts + ", price=" + price + "]";
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getNumberofproducts() {
		return numberofproducts;
	}
	public void setNumberofproducts(int numberofproducts) {
		this.numberofproducts = numberofproducts;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
