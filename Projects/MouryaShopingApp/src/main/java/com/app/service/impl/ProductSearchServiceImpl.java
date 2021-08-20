package com.app.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductSearchDao;
import com.app.dao.impl.ProductSearchDaoImpl;
import com.app.main.MainApp;
import com.app.model.Product;
import com.app.service.ProductSearchService;

public class ProductSearchServiceImpl implements ProductSearchService{
	private static Logger log= Logger.getLogger(MainApp.class);
	ProductSearchDao psd= new ProductSearchDaoImpl();
	@Override
	public List<Product> getProductById(int id) {
		List<Product> productList = null;
		if(id>0) {
			productList=psd.getProductById(id);
		}
		else {
			log.info("Invalid id");
		}
		return productList;
	}

	@Override
	public List<Product> getProductByName(String productName) {
		
		List<Product> productList = null;
		if(productName.matches("[a-zA-Z]{2,25}")) {
			productList = psd.getProductByName(productName);
		}
		else {
			log.info("Invalid name entry");
		}
		return productList;
	}

	@Override
	public List<Product> getProductByType(String typeOfProduct) {
		
		List<Product> productList = null;
		if(typeOfProduct.matches("[a-zA-Z]{2,25}")) {
			productList = psd.getProductByType(typeOfProduct);
		}
		else {
			log.info("Invalid name entry");
		}
		return productList;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList=null;
		productList = psd.getAllproducts();
		return productList;
	}

}
