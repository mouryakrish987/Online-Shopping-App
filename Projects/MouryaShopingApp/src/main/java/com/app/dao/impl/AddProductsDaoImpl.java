package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.AddProductsDao;
import com.app.exception.BusinessException;
import com.app.utlity.JavaDbConnection;

public class AddProductsDaoImpl implements AddProductsDao{
	public static Logger log= Logger.getLogger(AddProductsDaoImpl.class);
	@Override
	public int addProducts(String productname, int Numberofproducts, double price, String productType) throws BusinessException {
		int c=0;
		try(Connection connection = JavaDbConnection.getConnection()){
			String sql="INSERT INTO product (productname, NumberofProducts, price, producttype) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, productname);
			preparedStatement.setInt(2, Numberofproducts);
			preparedStatement.setDouble(3, price);
			preparedStatement.setString(4, productType);
			c=preparedStatement.executeUpdate();
			if(c!=1) {
				throw new BusinessException("Invalid creditentials");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	

}
