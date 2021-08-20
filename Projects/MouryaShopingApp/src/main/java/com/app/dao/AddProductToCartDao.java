package com.app.dao;

import com.app.exception.BusinessException;

public interface AddProductToCartDao {
	public int AddProductToCart(int productid,int customerid) throws BusinessException;
}
