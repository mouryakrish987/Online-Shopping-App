package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.CustomerRegistrationDao;
import com.app.exception.BusinessException;
import com.app.utlity.JavaDbConnection;

public class CustomerRegistrationDaoImpl implements CustomerRegistrationDao{
	Logger log=Logger.getLogger(CustomerLoginDaoImpl.class);

	@Override
	public int customerRegistrationStatus(String name, String email, String password, String phoneNo) throws BusinessException {
		int c=0;
		try(Connection connection= JavaDbConnection.getConnection()){
		String sql="insert into customer(name,email, password, phoneNo) values(?,?,?,?)";
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, phoneNo);
		c= preparedStatement.executeUpdate();
		if(c!=1) {
			throw new BusinessException("Invalid credidentials");
		}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
}
