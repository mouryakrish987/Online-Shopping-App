package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CartOperationsDao;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.utlity.JavaDbConnection;

public class CartOperationsDaoImpl implements CartOperationsDao{
	public static Logger log =Logger.getLogger(ViewCustomerDaoImpl.class);
	@Override
	public List<Product> viewCart(int id) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		try(Connection connection = JavaDbConnection.getConnection()){
			String sql="select * from product where productid in (select cart.productid from cart where cart.customerid=?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setProductid(resultSet.getInt("productid"));
				product.setProductName(resultSet.getString("productname"));
				product.setNumberofproducts(resultSet.getInt("NumberofProducts"));
				product.setPrice(resultSet.getDouble("price"));
				product.setProductType(resultSet.getString("producttype"));
				productList.add(product);
			}
			if(productList.size()==0) {
				throw new BusinessException("No products in cart");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	@Override
	public double totalPrice(int id) throws BusinessException {
		double totalPrice=0;
		try(Connection connection = JavaDbConnection.getConnection()){
			String sql="select sum(Cast(price as decimal(10,3))) as totalPrice from product where productid in (select cart.productid from cart where cart.customerid=?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				totalPrice = resultSet.getDouble("totalPrice");
			}
			else {
				throw new BusinessException("No products in cart");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalPrice;
	}

}
