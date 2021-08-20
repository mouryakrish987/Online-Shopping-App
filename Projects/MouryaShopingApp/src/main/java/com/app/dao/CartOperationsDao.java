package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface CartOperationsDao {
	public List<Product> viewCart(int id) throws BusinessException;
	public double totalPrice(int id) throws BusinessException;
}
