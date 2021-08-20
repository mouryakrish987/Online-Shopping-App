package com.app.dao;



import com.app.exception.BusinessException;

public interface CustomerLoginDao {
	public int customerLoginStatus(String email, String password) throws BusinessException;
}
