package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.CustomerLoginDao;
import com.app.exception.BusinessException;
import com.app.utlity.JavaDbConnection;



public class CustomerLoginDaoImpl  implements CustomerLoginDao{
	Logger log=Logger.getLogger(CustomerLoginDaoImpl.class);
	@Override
	public int customerLoginStatus(String email, String password) throws BusinessException {
		int result=0;
		
		try(Connection connection= JavaDbConnection.getConnection()){
			
			String sql= "Select * from customer where email= ? and password= ?";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet =preparedStatement.executeQuery();
			if(resultSet.next()) {
				result=resultSet.getInt("customerid");
			}
			else {
				throw new BusinessException("invalid email"+email+" or password"+password);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
		} 
		return result;
	}

}
