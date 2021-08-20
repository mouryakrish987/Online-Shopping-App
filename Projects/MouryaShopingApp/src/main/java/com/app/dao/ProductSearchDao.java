package com.app.dao;

import java.util.List;

import com.app.model.Product;

public interface ProductSearchDao {
	public List<Product> getProductById(int id);
	public List<Product> getProductByName(String productName);
	public List<Product> getProductByType(String typeOfProduct);
	public List<Product> getAllproducts();
}
