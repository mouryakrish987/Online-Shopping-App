package com.app.dao;

import com.app.exception.BusinessException;

public interface CustomerRegistrationDao {
	public int customerRegistrationStatus( String name, String email, String password, String phoneNo) throws BusinessException;
}
