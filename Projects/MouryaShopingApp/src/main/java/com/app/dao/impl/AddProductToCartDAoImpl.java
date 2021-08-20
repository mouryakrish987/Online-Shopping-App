package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.AddProductToCartDao;
import com.app.exception.BusinessException;
import com.app.utlity.JavaDbConnection;

public class AddProductToCartDAoImpl implements AddProductToCartDao{
	Logger log=Logger.getLogger(CustomerLoginDaoImpl.class);
	
	@Override
	public int AddProductToCart(int productid, int customerid) throws BusinessException {
		
		int c=0;
		try(Connection connection= JavaDbConnection.getConnection()){
		String sql="INSERT INTO cart (productid, customerid) VALUES (?, ?) ";
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setInt(1, productid);
		preparedStatement.setInt(2, customerid);
		c= preparedStatement.executeUpdate();
		if(c!=1) {
			throw new BusinessException("Invalid product it");
		}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	

}
