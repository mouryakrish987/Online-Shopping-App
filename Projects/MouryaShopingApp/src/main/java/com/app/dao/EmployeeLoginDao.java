package com.app.dao;

import com.app.exception.BusinessException;

public interface EmployeeLoginDao {
	public int employeeLoginStatus(String Username, String password) throws BusinessException;
}
