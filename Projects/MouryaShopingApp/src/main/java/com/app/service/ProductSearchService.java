package com.app.service;

import java.util.List;

import com.app.model.Product;

public interface ProductSearchService {
	public List<Product> getProductById(int id);
	public List<Product> getProductByName(String productName);
	public List<Product> getProductByType(String typeOfProduct);
	public List<Product> getAllProducts();
}
