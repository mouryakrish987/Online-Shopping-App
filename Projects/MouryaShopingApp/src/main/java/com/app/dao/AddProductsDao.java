package com.app.dao;

import com.app.exception.BusinessException;

public interface AddProductsDao {
	public int addProducts(String productname, int Numberofproducts, double price , String productType) throws BusinessException;
}
