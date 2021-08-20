package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeLoginDao;
import com.app.exception.BusinessException;
import com.app.utlity.JavaDbConnection;

public class EmployeeLoginDaoImpl implements EmployeeLoginDao{
	Logger log=Logger.getLogger(CustomerLoginDaoImpl.class);
	@Override
	public int employeeLoginStatus(String email, String password) throws BusinessException {
		int result=0;
			try(Connection connection= JavaDbConnection.getConnection()){
			
				String sql= "Select * from employee where email= ? and password= ?";
				PreparedStatement preparedStatement =connection.prepareStatement(sql);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, password);
				ResultSet resultSet =preparedStatement.executeQuery();
				if(resultSet.next()) {
					result=1;
				}
				else {
					throw new BusinessException("invalid email" + email +" or password"+password);
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e.getMessage());
			} 
		return result;
	}

}
