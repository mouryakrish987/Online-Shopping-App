package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.PlaceOrderDao;
import com.app.exception.BusinessException;
import com.app.utlity.JavaDbConnection;

public class PlaceOrderDaoImpl implements PlaceOrderDao{

	@Override
	public int placeOrder(int productid, int customerid) throws BusinessException {
		int c=0;
		String status="Order Placed";
		try(Connection connection= JavaDbConnection.getConnection()){
		String sql="INSERT INTO project1.order (orderStatus, customerid, productid) VALUES (?, ?,?)";
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setString(1, status);
		preparedStatement.setInt(2, customerid);
		preparedStatement.setInt(3, productid);
		c= preparedStatement.executeUpdate();
		if(c!=1) {
			throw new BusinessException("Invalid product id");
		}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
