package com.app.dao;

import com.app.exception.BusinessException;

public interface PlaceOrderDao {
	public int placeOrder(int productid, int customerid) throws BusinessException;
	
}
